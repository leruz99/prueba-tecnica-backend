package com.prueba.backeend.service.impl;

import com.prueba.backeend.domain.dto.ProductoDTO;
import com.prueba.backeend.domain.entities.Empresa;
import com.prueba.backeend.domain.entities.Producto;
import com.prueba.backeend.domain.mapper.ProductoMapper;
import com.prueba.backeend.repository.EmpresaRepository;
import com.prueba.backeend.repository.ProductoRepository;
import com.prueba.backeend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public ProductoDTO registrarProducto(ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.toProducto(productoDTO);
        Empresa empresa = empresaRepository.findById(productoDTO.empresaNit())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        producto.setEmpresa(empresa);
        Producto savedProducto = productoRepository.save(producto);
        return ProductoMapper.toProductoDTO(savedProducto);
    }

    @Override
    public ProductoDTO actualizarProducto(Long codigo, ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.toProducto(productoDTO);
        producto.setCodigo(codigo);
        Empresa empresa = empresaRepository.findById(productoDTO.empresaNit())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        producto.setEmpresa(empresa);
        Producto updatedProducto = productoRepository.save(producto);
        return ProductoMapper.toProductoDTO(updatedProducto);
    }

    @Override
    public void eliminarProducto(Long codigo) {
        productoRepository.deleteById(codigo);
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll().stream()
                .map(ProductoMapper::toProductoDTO)
                .collect(Collectors.toList());
    }
}
