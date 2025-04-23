package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    Page<Servico> findAllByPessoaNomeContainingIgnoreCaseAndDataEntradaAfterAndDataEntregaAfter(String nome, Date dataEntrada, Date dataEntrega, Pageable pageable);

}

