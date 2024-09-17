package com.prueba.backeend.repository;


import com.prueba.backeend.domain.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

    Optional<Empresa> findByNit(Long id);
}
