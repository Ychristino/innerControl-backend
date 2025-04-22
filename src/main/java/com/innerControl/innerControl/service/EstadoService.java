package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.estado.EstadoForm;
import com.innerControl.innerControl.controller.form.estado.EstadoUpdateForm;
import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisService paisService;

    public Page<Estado> listarTodos(Pageable pageable) {
        return estadoRepository.findAll(pageable);
    }

    public List<Estado> listarTodos() {
        return estadoRepository.findAll();
    }

    public Page<Estado> listarTodosPorPais(Long paisId, Pageable pageable) {
        return estadoRepository.findAllByPaisId(paisId, pageable);
    }

    public List<Estado> listarTodosPorPais(Long paisId) {
        return estadoRepository.findAllByPaisId(paisId);
    }

    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estado não encontrado!"));
    }
    public Estado buscarPorCreateForm(EstadoForm estadoForm){
        Pais pais = paisService.buscar(estadoForm.getPais());

        return estadoRepository.findByNomeAndSiglaAndPais(
                estadoForm.getNome(),
                estadoForm.getSigla(),
                pais
        ).orElse(null);
    }

    public Estado buscarPorUpdateForm(EstadoUpdateForm estadoForm){
        Pais pais = paisService.buscar(estadoForm.getPais());

        return estadoRepository.findByNomeAndSiglaAndPais(
                estadoForm.getNome(),
                estadoForm.getSigla(),
                pais
        ).orElse(null);
    }

    @Transactional
    public Estado criar(EstadoForm estadoForm){

        //Pais pais = paisService.criar(estadoForm.getPais());
        Pais pais = paisService.buscar(estadoForm.getPais());
        if (pais == null)
            throw new IllegalArgumentException("País não encontrado: " + estadoForm.getPais().getNome());

        Estado estado = estadoRepository.findByNomeAndSiglaAndPais(
                estadoForm.getNome(),
                estadoForm.getSigla(),
                pais
        ).orElse(null);

        if (estado != null){
            estado.setPais(pais);
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
        }
        else {
            estado = new Estado();
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
            estado.setPais(pais);
            estado = estadoRepository.save(estado);
        }
        return estado;

    }

    @Transactional
    public Estado atualizar(EstadoUpdateForm estadoForm){

        //Pais pais = paisService.atualizar(estadoForm.getPais());
        Pais pais = paisService.buscar(estadoForm.getPais());
        if (pais == null)
            throw new IllegalArgumentException("País não encontrado: " + estadoForm.getPais().getNome());

        Estado estado = estadoRepository.findByNomeAndSiglaAndPais(
                estadoForm.getNome(),
                estadoForm.getSigla(),
                pais
        ).orElse(null);

        if (estado != null){
            estado.setPais(pais);
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
        }
        else {
            estado = new Estado();
            estado.setNome(estadoForm.getNome());
            estado.setSigla(estadoForm.getSigla());
            estado.setPais(pais);
            estado = estadoRepository.save(estado);
        }
        return estado;

    }
}
