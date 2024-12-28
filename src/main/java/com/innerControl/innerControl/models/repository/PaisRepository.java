package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findByNomeAndSigla(String nome, String sigla);
}

