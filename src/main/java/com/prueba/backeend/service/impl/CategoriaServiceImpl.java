package com.prueba.backeend.service.impl;

import com.prueba.backeend.domain.dto.CategoriaDTO;
import com.prueba.backeend.domain.entities.Categoria;
import com.prueba.backeend.domain.mapper.CategoriaMapper;
import com.prueba.backeend.repository.CategoriaRepository;
import com.prueba.backeend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO registrarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toCategoria(categoriaDTO);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return CategoriaMapper.toCategoriaDTO(savedCategoria);
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toCategoria(categoriaDTO);
        categoria.setId(id);  // Aseguramos que el ID no cambie
        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return CategoriaMapper.toCategoriaDTO(updatedCategoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaMapper::toCategoriaDTO)
                .collect(Collectors.toList());
    }
}
