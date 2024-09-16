package com.prueba.backeend.service.impl;

import com.prueba.backeend.domain.dto.OrdenDTO;
import com.prueba.backeend.domain.entities.Cliente;
import com.prueba.backeend.domain.entities.Orden;
import com.prueba.backeend.domain.entities.Producto;
import com.prueba.backeend.domain.mapper.OrdenMapper;
import com.prueba.backeend.repository.ClienteRepository;
import com.prueba.backeend.repository.OrdenRepository;
import com.prueba.backeend.repository.ProductoRepository;
import com.prueba.backeend.service.OrdenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public OrdenDTO registrarOrden(OrdenDTO ordenDTO) {
        Orden orden = OrdenMapper.toOrden(ordenDTO);
        Cliente cliente = clienteRepository.findById(ordenDTO.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        orden.setCliente(cliente);

        List<Producto> productos = productoRepository.findAllById(ordenDTO.productosIds());
        orden.setProductos(productos.stream().collect(Collectors.toSet()));

        Orden savedOrden = ordenRepository.save(orden);
        return OrdenMapper.toOrdenDTO(savedOrden);
    }

    @Override
    public OrdenDTO actualizarOrden(Long id, OrdenDTO ordenDTO) {
        Orden orden = OrdenMapper.toOrden(ordenDTO);
        orden.setId(id);
        Cliente cliente = clienteRepository.findById(ordenDTO.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        orden.setCliente(cliente);

        List<Producto> productos = productoRepository.findAllById(ordenDTO.productosIds());
        orden.setProductos(productos.stream().collect(Collectors.toSet()));

        Orden updatedOrden = ordenRepository.save(orden);
        return OrdenMapper.toOrdenDTO(updatedOrden);
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<OrdenDTO> listarOrdenes() {
        return ordenRepository.findAll().stream()
                .map(OrdenMapper::toOrdenDTO)
                .collect(Collectors.toList());
    }
}
