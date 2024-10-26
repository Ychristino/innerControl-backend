package com.innerControl.models.repository;

import com.innerControl.models.Cidade;
import com.innerControl.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findByEstadoAndNome(Estado estado, String nome);
}
