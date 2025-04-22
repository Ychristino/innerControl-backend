package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.cidade.CidadeForm;
import com.innerControl.innerControl.controller.form.cidade.CidadeUpdateForm;
import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeRepository cidadeRepository;

    public Page<Cidade> listarTodos(Pageable pageable) {
        return cidadeRepository.findAll(pageable);
    }

    public List<Cidade> listarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada!"));
    }

    public Cidade buscar(CidadeForm cidadeForm){
        Pais pais;
        if (cidadeForm.getPais() != null) {
            pais = paisService.buscar(cidadeForm.getPais());
        }
        else{
            pais = paisService.buscar(cidadeForm.getEstado().getPais());
        }

        Estado estado = estadoService.buscarPorCreateForm(cidadeForm.getEstado());

        return cidadeRepository.findByNomeAndEstado(
                cidadeForm.getNome(),
                estado
        ).orElse(null);
    }

    public Cidade buscar(CidadeUpdateForm cidadeForm){
        Pais pais;
        if (cidadeForm.getPais() != null) {
            pais = paisService.buscar(cidadeForm.getPais());
        }
        else{
            pais = paisService.buscar(cidadeForm.getEstado().getPais());
        }

        Estado estado = estadoService.buscarPorUpdateForm(cidadeForm.getEstado());

        return cidadeRepository.findByNomeAndEstado(
                cidadeForm.getNome(),
                estado
        ).orElse(null);
    }

    @Transactional
    public Cidade criar(CidadeForm cidadeForm) {
        // Processar País
        Pais pais;
        if (cidadeForm.getPais() != null) {
            //pais = paisService.criar(cidadeForm.getPais());
            pais = paisService.buscar(cidadeForm.getPais());
        }
        else{
            //pais = paisService.criar(cidadeForm.getEstado().getPais());
            pais = paisService.buscar(cidadeForm.getEstado().getPais());
        }
        if (pais == null)
            throw new IllegalArgumentException("País não encontrado: " + cidadeForm.getPais().getNome());

        // Processar Estado
        //Estado estado = estadoService.criar(cidadeForm.getEstado());
        Estado estado = estadoService.buscarPorCreateForm(cidadeForm.getEstado());
        if (estado == null)
            throw new IllegalArgumentException("Estado não encontrado: " + cidadeForm.getEstado().getNome());

        // Processar Cidade
        Cidade cidade = cidadeRepository.findByNomeAndEstado(
                cidadeForm.getNome(),
                estado
        ).orElse(null);

        if (cidade != null) {
            cidade.setPais(pais);
            cidade.setEstado(estado);
            cidade.setNome(cidadeForm.getNome());
        } else {
            cidade = new Cidade();
            cidade.setPais(pais);
            cidade.setEstado(estado);
            cidade.setNome(cidadeForm.getNome());
            cidade = cidadeRepository.save(cidade);
        }
        return cidade;
    }

    @Transactional
    public Cidade atualizar(CidadeUpdateForm cidadeForm) {
        // Processar País
        Pais pais;
        if (cidadeForm.getPais() != null) {
            //pais = paisService.atualizar(cidadeForm.getPais());
            pais = paisService.buscar(cidadeForm.getPais());
        }
        else{
            //pais = paisService.atualizar(cidadeForm.getEstado().getPais());
            pais = paisService.buscar(cidadeForm.getEstado().getPais());
        }
        if (pais == null)
            throw new IllegalArgumentException("País não encontrado: " + cidadeForm.getPais().getNome());

        // Processar Estado
        //Estado estado = estadoService.atualizar(cidadeForm.getEstado());
        Estado estado = estadoService.buscarPorUpdateForm(cidadeForm.getEstado());
        if (estado == null)
            throw new IllegalArgumentException("Estado não encontrado: " + cidadeForm.getEstado().getNome());

        // Processar Cidade (ou atualizar se já existir)
        Cidade cidade = cidadeRepository.findByNomeAndEstado(
                cidadeForm.getNome(),
                estado
        ).orElse(null);

        if (cidade != null) {
            cidade.setPais(pais);
            cidade.setEstado(estado);
            cidade.setNome(cidadeForm.getNome());
        } else {
            cidade = new Cidade();
            cidade.setPais(pais);
            cidade.setEstado(estado);
            cidade.setNome(cidadeForm.getNome());
            cidade = cidadeRepository.save(cidade);
        }
        return cidade;
    }
}
