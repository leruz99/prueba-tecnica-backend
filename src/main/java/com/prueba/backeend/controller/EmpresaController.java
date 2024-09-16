package com.prueba.backeend.controller;


import com.prueba.backeend.domain.dto.EmpresaDTO;
import com.prueba.backeend.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDTO> registrarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        EmpresaDTO nuevaEmpresa = empresaService.registrarEmpresa(empresaDTO);
        return ResponseEntity.ok(nuevaEmpresa);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<EmpresaDTO> actualizarEmpresa(@PathVariable String nit, @RequestBody EmpresaDTO empresaDTO) {
        EmpresaDTO empresaActualizada = empresaService.actualizarEmpresa(nit, empresaDTO);
        return ResponseEntity.ok(empresaActualizada);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable String nit) {
        empresaService.eliminarEmpresa(nit);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listarEmpresas() {
        List<EmpresaDTO> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }
}
