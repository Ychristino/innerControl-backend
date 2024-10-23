package com.innerControl.controller.form.contato;

import com.innerControl.models.Contato;
import com.innerControl.models.PessoaFisica;
import com.innerControl.models.TipoContato;
import com.innerControl.models.repository.ContatoRepository;

public class AtualizarContatoForm {

    private TipoContato tipoContato;
    private PessoaFisica pessoaFisica;
    private String contato;

    public Contato converter(){ return new Contato(tipoContato, pessoaFisica, contato); }

    public Contato atualizar(Long id, ContatoRepository contatoRepository){
        Contato contato = contatoRepository.getReferenceById(id);
        contato.setTipoContato(this.tipoContato);
        contato.setPessoaFisica(this.pessoaFisica);
        contato.setContato(this.contato);
        return contato;
    }
}
