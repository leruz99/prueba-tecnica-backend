package com.prueba.backeend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_generator")
    @SequenceGenerator(name="producto_id_generator", sequenceName = "producto_id_seq")
    private Long codigo;
    private String nombre;
    private String caracteristicas;
    private Double precio;

    @ManyToOne
    private Empresa empresa;

    @ManyToMany
    private Set<Categoria> categorias;
}
