package com.prueba.backeend.domain.mapper;


import com.prueba.backeend.domain.dto.CategoriaDTO;
import com.prueba.backeend.domain.entities.Categoria;

public class CategoriaMapper {
    public static CategoriaDTO toCategoriaDTO(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNombre()
        );
    }

    public static Categoria toCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.id());
        categoria.setNombre(categoriaDTO.nombre());
        return categoria;
    }
}
