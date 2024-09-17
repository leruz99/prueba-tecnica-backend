package com.prueba.backeend.service.impl;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.prueba.backeend.domain.dto.EmpresaDTO;
import com.prueba.backeend.domain.dto.InventarioDTO;
import com.prueba.backeend.domain.dto.ProductoDTO;
import com.prueba.backeend.service.EmpresaService;
import com.prueba.backeend.service.PdfService;
import com.prueba.backeend.service.ProductoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PdfServiceImpl implements PdfService {
    private final ProductoService productoService;
    private final EmpresaService empresaService;

    public PdfServiceImpl(ProductoService productoService, EmpresaService empresaService) {
        this.productoService = productoService;
        this.empresaService = empresaService;
    }

    @Override
    public ByteArrayResource generatePdf(List<InventarioDTO> inventarioList) throws DocumentException {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        for (InventarioDTO item : inventarioList) {
            document.add(new Paragraph("Código: " + item.getCodigo()));
            document.add(new Paragraph("Nombre: " + item.getNombre()));
            document.add(new Paragraph("Características: " + item.getCaracteristicas()));
            document.add(new Paragraph("Precio: " + item.getPrecio()));
            document.add(new Paragraph("Empresa: " + item.getEmpresa()));
            document.add(new Paragraph(" "));
        }
        document.close();
        return new ByteArrayResource(out.toByteArray());
    }

    @Override
    public List<InventarioDTO> generateInventario() {
        List<ProductoDTO> productos = productoService.listarProductos();
        List<EmpresaDTO> empresas = empresaService.listarEmpresas();

        List<InventarioDTO> inventario = productos.stream()
                .map(producto -> {

                    EmpresaDTO empresa = empresas.stream()
                            .filter(emp -> emp.nit().equals(producto.empresaNit()))
                            .findFirst()
                            .orElse(null);

                    InventarioDTO inventarioDTO = new InventarioDTO();
                    inventarioDTO.setCodigo(producto.codigo());
                    inventarioDTO.setNombre(producto.nombre());
                    inventarioDTO.setCaracteristicas(producto.caracteristicas());
                    inventarioDTO.setPrecio(producto.precio());
                    inventarioDTO.setEmpresa(empresa != null ? empresa.nombre() : "Empresa no encontrada");

                    return inventarioDTO;
                })
                .collect(Collectors.toList());
        return inventario;
    }
}
