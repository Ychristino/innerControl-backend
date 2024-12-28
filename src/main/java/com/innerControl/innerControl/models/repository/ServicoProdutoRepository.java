package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.ServicoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoProdutoRepository extends JpaRepository<ServicoProduto, Long> {
    Optional<ServicoProduto> findByProdutoId(Long id);
}
