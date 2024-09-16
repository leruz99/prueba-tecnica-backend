package com.prueba.backeend.service;



import com.prueba.backeend.domain.dto.OrdenDTO;

import java.util.List;

public interface OrdenService {
    OrdenDTO registrarOrden(OrdenDTO ordenDTO);
    OrdenDTO actualizarOrden(Long id, OrdenDTO ordenDTO);
    void eliminarOrden(Long id);
    List<OrdenDTO> listarOrdenes();
}