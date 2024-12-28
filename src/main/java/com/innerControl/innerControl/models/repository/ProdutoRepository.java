package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) = LOWER(:nome)")
    Optional<Produto> findByNome(@Param("nome") String nome);
}

