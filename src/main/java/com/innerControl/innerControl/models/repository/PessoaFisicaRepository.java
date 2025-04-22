package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.PessoaFisica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Optional<PessoaFisica> findByCpf(String cpf);

    Page<PessoaFisica> findAllByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
