package com.prueba.backeend.domain.mapper;


import com.prueba.backeend.domain.dto.ProductoDTO;
import com.prueba.backeend.domain.entities.Producto;

public class ProductoMapper {
    public static ProductoDTO toProductoDTO(Producto producto) {
        return new ProductoDTO(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getCaracteristicas(),
                producto.getPrecio(),
                producto.getEmpresa().getNit()  // Se obtiene el NIT de la empresa
        );
    }

    public static Producto toProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setCodigo(productoDTO.codigo());
        producto.setNombre(productoDTO.nombre());
        producto.setCaracteristicas(productoDTO.caracteristicas());
        producto.setPrecio(productoDTO.precio());
        return producto;
    }
}
