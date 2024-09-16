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
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_generator")
    @SequenceGenerator(name="cliente_id_generator", sequenceName = "cliente_id_seq")
    private Long id;
    private String nombre;
    private String correo;

    @OneToMany(mappedBy = "cliente")
    private Set<Orden> ordenes;
}
