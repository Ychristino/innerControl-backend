package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
    Optional<PessoaFisica> findByCpf(String cpf);

}
