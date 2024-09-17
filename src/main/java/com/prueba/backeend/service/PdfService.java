package com.prueba.backeend.service;

import com.itextpdf.text.DocumentException;
import com.prueba.backeend.domain.dto.InventarioDTO;
import org.springframework.core.io.ByteArrayResource;

import java.util.List;

public interface PdfService {
    ByteArrayResource generatePdf(List<InventarioDTO> inventarioList) throws DocumentException;
    List<InventarioDTO> generateInventario();
}
