package com.prueba.backeend.domain.mapper;


import com.prueba.backeend.domain.dto.EmpresaDTO;
import com.prueba.backeend.domain.entities.Empresa;

public class EmpresaMapper {
    public static EmpresaDTO toEmpresaDTO(Empresa empresa) {
        return new EmpresaDTO(
                empresa.getNit(),
                empresa.getNombre(),
                empresa.getDireccion(),
                empresa.getTelefono()
        );
    }

    public static Empresa toEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setNit(empresaDTO.nit());
        empresa.setNombre(empresaDTO.nombre());
        empresa.setDireccion(empresaDTO.direccion());
        empresa.setTelefono(empresaDTO.telefono());
        return empresa;
    }
}
