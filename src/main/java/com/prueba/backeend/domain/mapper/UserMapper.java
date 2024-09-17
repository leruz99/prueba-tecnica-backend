package com.prueba.backeend.domain.mapper;

import com.prueba.backeend.domain.dto.CreateUserRequest;
import com.prueba.backeend.domain.dto.UserDTO;
import com.prueba.backeend.domain.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public static UserDTO convertToDTO(User user) {
        if (user == null) {
            return null;
        }


        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getToken(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getLastLogin(),
                user.isActive());
    }

    public static User convertToEntity(CreateUserRequest request) {
        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPassword(request.password());
        LocalDateTime now = LocalDateTime.now();
        newUser.setCreatedAt(now);
        newUser.setLastLogin(now);
        newUser.setActive(true);
        newUser.setRole(request.role());
        return newUser;
    }
}
