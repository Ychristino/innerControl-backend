package com.innerControl.models.repository;

import com.innerControl.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository  extends JpaRepository<Contato, Long> {
}
