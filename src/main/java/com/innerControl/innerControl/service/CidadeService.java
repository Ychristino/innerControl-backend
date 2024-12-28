package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.cidade.CidadeForm;
import com.innerControl.innerControl.controller.form.cidade.CidadeUpdateForm;
import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.repository.CidadeRepository;
import com.innerControl.innerControl.models.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public Cidade criar(CidadeForm cidadeForm) {
        // Processar País
        Pais pais;
        if (cidadeForm.getPais() != null) {
            pais = paisService.criar(cidadeForm.getPais());
        }
        else{
            pais = paisService.criar(cidadeForm.getEstado().getPais());
        }

        // Processar Estado
        Estado estado = estadoService.criar(cidadeForm.getEstado(), pais);

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
            pais = paisService.atualizar(cidadeForm.getPais());
        }
        else{
            pais = paisService.atualizar(cidadeForm.getEstado().getPais());
        }

        // Processar Estado
        Estado estado = estadoService.atualizar(cidadeForm.getEstado(), pais);

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
