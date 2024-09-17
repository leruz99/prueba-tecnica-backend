package com.prueba.backeend.service.impl;

import com.prueba.backeend.domain.dto.EmpresaDTO;
import com.prueba.backeend.domain.entities.Empresa;
import com.prueba.backeend.domain.mapper.EmpresaMapper;
import com.prueba.backeend.repository.EmpresaRepository;
import com.prueba.backeend.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {


    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public EmpresaDTO registrarEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = EmpresaMapper.toEmpresa(empresaDTO);
        Empresa savedEmpresa = empresaRepository.save(empresa);
        return EmpresaMapper.toEmpresaDTO(savedEmpresa);
    }

    @Override
    public EmpresaDTO actualizarEmpresa(Long nit, EmpresaDTO empresaDTO) {
        Empresa empresa = EmpresaMapper.toEmpresa(empresaDTO);
        empresa.setNit(nit);
        Empresa updatedEmpresa = empresaRepository.save(empresa);
        return EmpresaMapper.toEmpresaDTO(updatedEmpresa);
    }

    @Override
    public void eliminarEmpresa(String nit) {
        empresaRepository.deleteById(nit);
    }

    @Override
    public List<EmpresaDTO> listarEmpresas() {
        return empresaRepository.findAll().stream()
                .map(EmpresaMapper::toEmpresaDTO)
                .collect(Collectors.toList());
    }
}
