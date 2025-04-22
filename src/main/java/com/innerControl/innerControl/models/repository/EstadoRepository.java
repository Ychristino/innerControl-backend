package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeAndSiglaAndPais(String nome, String sigla, Pais pais);

    Page<Estado> findAllByPaisId(Long paisId, Pageable pageable);
    List<Estado> findAllByPaisId(Long paisId);
}
