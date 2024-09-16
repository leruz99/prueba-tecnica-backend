package com.prueba.backeend.controller;

import com.prueba.backeend.domain.dto.OrdenDTO;
import com.prueba.backeend.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<OrdenDTO> registrarOrden(@RequestBody OrdenDTO ordenDTO) {
        OrdenDTO nuevaOrden = ordenService.registrarOrden(ordenDTO);
        return ResponseEntity.ok(nuevaOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenDTO> actualizarOrden(@PathVariable Long id, @RequestBody OrdenDTO ordenDTO) {
        OrdenDTO ordenActualizada = ordenService.actualizarOrden(id, ordenDTO);
        return ResponseEntity.ok(ordenActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        ordenService.eliminarOrden(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OrdenDTO>> listarOrdenes() {
        List<OrdenDTO> ordenes = ordenService.listarOrdenes();
        return ResponseEntity.ok(ordenes);
    }
}
