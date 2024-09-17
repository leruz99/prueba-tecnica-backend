package com.prueba.backeend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_id_generator")
    @SequenceGenerator(name="empresa_id_generator", sequenceName = "empresa_id_seq")
    private Long nit;
    private String nombre;
    private String direccion;
    private String telefono;
}
