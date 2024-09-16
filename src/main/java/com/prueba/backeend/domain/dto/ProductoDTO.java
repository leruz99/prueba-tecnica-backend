package com.prueba.backeend.domain.dto;

public record ProductoDTO(
        Long codigo,
        String nombre,
        String caracteristicas,
        Double precio,
        String empresaNit
) {
}
