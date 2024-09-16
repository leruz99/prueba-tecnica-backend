package com.prueba.backeend.service;



import com.prueba.backeend.domain.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaDTO registrarCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);
    void eliminarCategoria(Long id);
    List<CategoriaDTO> listarCategorias();
}
