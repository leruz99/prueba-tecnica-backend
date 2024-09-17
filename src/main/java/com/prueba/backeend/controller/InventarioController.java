package com.prueba.backeend.controller;

import com.itextpdf.text.DocumentException;
import com.prueba.backeend.domain.dto.EmpresaDTO;
import com.prueba.backeend.domain.dto.InventarioDTO;
import com.prueba.backeend.domain.dto.ProductoDTO;
import com.prueba.backeend.service.EmpresaService;
import com.prueba.backeend.service.PdfService;
import com.prueba.backeend.service.ProductoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    private final PdfService pdfService;

    public InventarioController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> getInventario() {
        return ResponseEntity.ok(pdfService.generateInventario());
    }
    @GetMapping("/downloadPdf")
    public ResponseEntity<ByteArrayResource> downloadPdf() throws IOException, DocumentException {
        List<InventarioDTO> inventarioList = pdfService.generateInventario();
        ByteArrayResource pdf = pdfService.generatePdf(inventarioList);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=inventario.pdf")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .contentLength(pdf.contentLength())
                .body(pdf);
    }
}
