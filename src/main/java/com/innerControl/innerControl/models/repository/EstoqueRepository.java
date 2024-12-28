package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Estoque;
import com.innerControl.innerControl.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByProduto(Produto produto);
    Optional<Estoque> findByProdutoNome(String nome);
    Optional<Estoque> findByProdutoId(Long id);
}

