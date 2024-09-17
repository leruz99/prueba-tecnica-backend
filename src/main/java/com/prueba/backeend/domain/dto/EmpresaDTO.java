package com.prueba.backeend.domain.dto;

public record EmpresaDTO(
        Long nit,
        String nombre,
        String direccion,
        String telefono
) {
}
