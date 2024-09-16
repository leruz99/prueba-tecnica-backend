package com.prueba.backeend.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record OrdenDTO (
        Long id,
        LocalDate fecha,
        Long clienteId,
        List<Long> productosIds
){
}
