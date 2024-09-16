package com.prueba.backeend.service;



import com.prueba.backeend.domain.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {
    ProductoDTO registrarProducto(ProductoDTO productoDTO);
    ProductoDTO actualizarProducto(Long codigo, ProductoDTO productoDTO);
    void eliminarProducto(Long codigo);
    List<ProductoDTO> listarProductos();
}