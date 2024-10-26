package com.innerControl.models.repository;

import com.innerControl.models.Contato;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository  extends JpaRepository<Contato, Long> {
    Optional<Contato> findByTipoContatoAndContatoAndPessoaFisicaNot(TipoContato tipo, String contato, PessoaFisica pessoaFisica);

}
