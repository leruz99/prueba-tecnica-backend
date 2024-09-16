package com.prueba.backeend.service;

import com.prueba.backeend.domain.dto.CreateUserRequest;
import com.prueba.backeend.domain.dto.CreateUserResponse;
import com.prueba.backeend.domain.dto.UserDTO;
import com.prueba.backeend.domain.entities.UserEntity;
import com.prueba.backeend.domain.enums.Role;
import com.prueba.backeend.domain.mapper.UserMapper;
import com.prueba.backeend.exeptions.EmailAlreadyExistsException;
import com.prueba.backeend.exeptions.InvalidPasswordFormatException;
import com.prueba.backeend.exeptions.ResourceNotFoundException;
import com.prueba.backeend.exeptions.UserRegistrationException;
import com.prueba.backeend.repository.UserRepository;
import com.prueba.backeend.security.jwt.TokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Value("${app.regex.password}")
    private String passwordRegex;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManagerBuilder authenticationManagerBuilder,
            TokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;
    }

    public List<UserDTO> getAll() {
        log.info("consulta de usuarios iniciada");
        return userRepository.findAll().stream().map(UserMapper::convertToDTO).collect(Collectors.toList());
    }

    public CreateUserResponse createUser(CreateUserRequest user, Role role) {
        try {
            validateEmail(user.email());
            validatePassword(user.password());
            String token = tokenProvider.createToken(
                    new UsernamePasswordAuthenticationToken(user.email(), Collections.singletonList(role)));
            UserEntity newUser = UserMapper.convertToEntity(user);
            newUser.setPassword(passwordEncoder.encode(user.password()));
            newUser.setToken(token);
            newUser.setRole(role);
            UserEntity savedUser = userRepository.save(newUser);
            log.info("Creación de Usuario con id={}", savedUser.getId());
            return buildSuccessResponse(savedUser);
        } catch (EmailAlreadyExistsException | InvalidPasswordFormatException ex) {
            log.error("Validación de Error: {}", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("Error inesperado durante el registro de usuario", ex);
            throw new UserRegistrationException("Error al registrar al usuario", ex);
        }
    }

    public String authenticate(CreateUserRequest request) {
        UserEntity user = userRepository
                .findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return authenticateUser(user, request);
    }

    private String authenticateUser(UserEntity user, CreateUserRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getEmail(), request.password());
        try {
            Authentication authentication =
                    authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return tokenProvider.createToken(authentication);
        } catch (AuthenticationException e) {
            log.error("Error de autenticación para el usuario: {}", request.email(), e);
            throw new AccessDeniedException("Error de autenticación", e);
        }
    }

    private CreateUserResponse<UserDTO> buildSuccessResponse(UserEntity user) {
        UserDTO userDTO = UserMapper.convertToDTO(user);
        CreateUserResponse<UserDTO> response = new CreateUserResponse<>();
        response.setBody(userDTO);
        response.setMessage("Usuario creado satisfactoriamente.");
        return response;
    }

    private void validateEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new EmailAlreadyExistsException("El correo de " + email + " ya se encuentra registrado");
        }
    }

    private void validatePassword(String password) {
        if (!password.matches(passwordRegex)) {
            throw new InvalidPasswordFormatException("Formato de contraseña es inválido");
        }
    }
}
