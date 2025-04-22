package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Servico;
import jakarta.persistence.TemporalType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query("SELECT s FROM Servico s " +
            "JOIN s.pessoa p " +
            "WHERE (:nome IS NULL OR p.nome LIKE %:nome%) " +
            "AND (:dataEntrada IS NULL OR s.dataEntrada = :dataEntrada) " +
            "AND (:dataEntrega IS NULL OR s.dataEntrega = :dataEntrega)")
    Page<Servico> buscarServicos(@Param("nome") String nome,
                                 @Param("dataEntrada") @Temporal(TemporalType.DATE) Date dataEntrada,
                                 @Param("dataEntrega") @Temporal(TemporalType.DATE) Date dataEntrega,
                                 Pageable pageable);
}

