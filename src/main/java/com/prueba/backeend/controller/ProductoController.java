package com.prueba.backeend.controller;

import com.prueba.backeend.domain.dto.ProductoDTO;
import com.prueba.backeend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDTO> registrarProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO nuevoProducto = productoService.registrarProducto(productoDTO);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long codigo, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoActualizado = productoService.actualizarProducto(codigo, productoDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long codigo) {
        productoService.eliminarProducto(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        List<ProductoDTO> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }
}
