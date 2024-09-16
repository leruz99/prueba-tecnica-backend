package com.prueba.backeend.domain.mapper;


import com.prueba.backeend.domain.dto.ClienteDTO;
import com.prueba.backeend.domain.entities.Cliente;

public class ClienteMapper {
    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getCorreo()
        );
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.id());
        cliente.setNombre(clienteDTO.nombre());
        cliente.setCorreo(clienteDTO.correo());
        return cliente;
    }
}
