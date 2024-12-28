package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findByNomeAndEstado(String nome, Estado estado);
}