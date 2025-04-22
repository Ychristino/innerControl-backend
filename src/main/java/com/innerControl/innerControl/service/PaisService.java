package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.pais.PaisForm;
import com.innerControl.innerControl.controller.form.pais.PaisUpdateForm;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.PessoaFisica;
import com.innerControl.innerControl.models.repository.PaisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public Page<Pais> listarTodos(Pageable pageable) {
        return paisRepository.findAll(pageable);
    }

    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }

    public Pais buscarPorId(Long id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("País não encontrada!"));
        return pais;
    }

    public Pais buscar(PaisForm paisForm){

        return paisRepository.findByNomeAndSigla(
                paisForm.getNome(),
                paisForm.getSigla()
        ).orElse(null);
    }

    public Pais buscar(PaisUpdateForm paisForm){

        return paisRepository.findByNomeAndSigla(
                paisForm.getNome(),
                paisForm.getSigla()
        ).orElse(null);
    }

    @Transactional
    public Pais criar(PaisForm paisForm){

        Pais pais = paisRepository.findByNomeAndSigla(
                paisForm.getNome(),
                paisForm.getSigla()
        ).orElse(null);

        if (pais != null){
            pais.setNome(paisForm.getNome());
            pais.setSigla(paisForm.getSigla());
        }
        else{
            pais = new Pais();
            pais.setNome(paisForm.getNome());
            pais.setSigla(paisForm.getSigla());
            pais = paisRepository.save(pais);
        }
        return pais;

    }

    @Transactional
    public Pais atualizar(PaisUpdateForm paisForm){

        Pais pais = paisRepository.findByNomeAndSigla(
                paisForm.getNome(),
                paisForm.getSigla()
        ).orElse(null);

        if (pais != null){
            pais.setNome(paisForm.getNome());
            pais.setSigla(paisForm.getSigla());
        }
        else{
            pais = new Pais();
            pais.setNome(paisForm.getNome());
            pais.setSigla(paisForm.getSigla());
            pais = paisRepository.save(pais);
        }
        return pais;

    }
}
