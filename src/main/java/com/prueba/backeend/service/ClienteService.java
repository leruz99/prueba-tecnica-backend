package com.prueba.backeend.service;



import com.prueba.backeend.domain.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO registrarCliente(ClienteDTO clienteDTO);
    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO);
    void eliminarCliente(Long id);
    List<ClienteDTO> listarClientes();
}
