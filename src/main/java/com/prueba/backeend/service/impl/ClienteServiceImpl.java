package com.prueba.backeend.service.impl;

import com.prueba.backeend.domain.dto.ClienteDTO;
import com.prueba.backeend.domain.entities.Cliente;
import com.prueba.backeend.domain.mapper.ClienteMapper;
import com.prueba.backeend.repository.ClienteRepository;
import com.prueba.backeend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toCliente(clienteDTO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return ClienteMapper.toClienteDTO(savedCliente);
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toCliente(clienteDTO);
        cliente.setId(id);
        Cliente updatedCliente = clienteRepository.save(cliente);
        return ClienteMapper.toClienteDTO(updatedCliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toClienteDTO)
                .collect(Collectors.toList());
    }
}