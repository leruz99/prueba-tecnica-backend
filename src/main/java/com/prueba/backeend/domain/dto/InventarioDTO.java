package com.prueba.backeend.domain.dto;

public class InventarioDTO {
    private Long codigo;
    private String nombre;
    private String caracteristicas;
    private Double precio;
    private String empresa;

    public InventarioDTO() {
    }

    public InventarioDTO(Long codigo, String nombre, String caracteristicas, Double precio, String empresa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.empresa = empresa;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
