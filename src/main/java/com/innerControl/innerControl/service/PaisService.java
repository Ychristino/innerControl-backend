package com.innerControl.innerControl.service;

import com.innerControl.innerControl.controller.form.pais.PaisForm;
import com.innerControl.innerControl.controller.form.pais.PaisUpdateForm;
import com.innerControl.innerControl.models.Pais;
import com.innerControl.innerControl.models.repository.PaisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

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
