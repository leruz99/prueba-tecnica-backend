package com.prueba.backeend.service;



import com.prueba.backeend.domain.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaService {
    EmpresaDTO registrarEmpresa(EmpresaDTO empresaDTO);
    EmpresaDTO actualizarEmpresa(String nit, EmpresaDTO empresaDTO);
    void eliminarEmpresa(String nit);
    List<EmpresaDTO> listarEmpresas();
}
