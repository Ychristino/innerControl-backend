package com.innerControl.service;

import com.innerControl.dto.estado.EstadoDto;
import com.innerControl.dto.pais.PaisDto;
import com.innerControl.erros.EstadoNaoExistente;
import com.innerControl.erros.EstadoPaisInconsistente;
import com.innerControl.erros.InsercaoDadoErro;
import com.innerControl.erros.PaisNaoExistente;
import com.innerControl.models.Cidade;
import com.innerControl.models.Endereco;
import com.innerControl.models.repository.CidadeRepository;
import com.innerControl.models.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PaisService paisService;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Endereco cadastroEndereco(Endereco endereco){
        if (!endereco.getEstado().getPais().getId().equals(endereco.getPais().getId()))
            throw new EstadoPaisInconsistente("País do estado não condiz com o local informado.");

        try {
            EstadoDto estado = estadoService.buscarEstado(endereco.getEstado().getId());
            PaisDto pais = paisService.buscarPais(estado.getPais().getId());
        }
        catch (PaisNaoExistente  | EstadoNaoExistente err){
            throw new InsercaoDadoErro("Erro ao encontrar Estado/País.");
        }

        Optional<Cidade> cidade = cidadeRepository.findByEstadoAndNome(endereco.getCidade().getEstado(), endereco.getCidade().getNome());
        if (cidade.isEmpty()) {
            cidadeRepository.save(endereco.getCidade());
        }

        enderecoRepository.save(endereco);

        return endereco;
    }
}
