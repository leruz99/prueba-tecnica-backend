package com.prueba.backeend.domain.dto;

import com.prueba.backeend.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        String name,
        @NotBlank(message = "Se requiere el correo electrónico del usuario")
        @Email(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "Ingresar el email valido.")
        String email,
        @NotBlank(message = "Se requiere contraseña de usuario") String password,
        Role role) {}