package com.prueba.backeend.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orden_id_generator")
    @SequenceGenerator(name="orden_id_generator", sequenceName = "orden_id_seq")
    private Long id;
    private LocalDate fecha;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Producto> productos;
}
