package com.prueba.backeend.domain.mapper;


import com.prueba.backeend.domain.dto.OrdenDTO;
import com.prueba.backeend.domain.entities.Orden;

import java.util.stream.Collectors;

public class OrdenMapper {
    public static OrdenDTO toOrdenDTO(Orden orden) {
        return new OrdenDTO(
                orden.getId(),
                orden.getFecha(),
                orden.getCliente().getId(),
                orden.getProductos().stream()
                        .map(producto -> producto.getCodigo())
                        .collect(Collectors.toList())
        );
    }

    public static Orden toOrden(OrdenDTO ordenDTO) {
        Orden orden = new Orden();
        orden.setId(ordenDTO.id());
        orden.setFecha(ordenDTO.fecha());
        return orden;
    }
}
