package com.prueba.backeend.service;

import com.prueba.backeend.domain.dto.CreateUserRequest;
import com.prueba.backeend.domain.dto.CreateUserResponse;
import com.prueba.backeend.domain.dto.UserDTO;
import com.prueba.backeend.domain.entities.User;
import com.prueba.backeend.domain.enums.Role;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    CreateUserResponse createUser(CreateUserRequest request, Role role);
    String authenticateUser(User user, CreateUserRequest request);
    String authenticate(CreateUserRequest request);
}
