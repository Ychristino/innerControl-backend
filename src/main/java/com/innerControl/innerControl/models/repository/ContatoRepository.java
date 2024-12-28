package com.innerControl.innerControl.models.repository;

import com.innerControl.innerControl.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
