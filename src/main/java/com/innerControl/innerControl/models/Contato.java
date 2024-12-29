package com.innerControl.innerControl.models;

import com.innerControl.innerControl.utils.ContatoEnum;
import com.innerControl.innerControl.utils.Validador;
import jakarta.persistence.*;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ContatoEnum tipo;
    private String valor;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_id")
    private PessoaFisica pessoaFisica;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public ContatoEnum getTipo() {
        return tipo;
    }

    public void setTipo(ContatoEnum tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        if (this.tipo == ContatoEnum.EMAIL){
            if (Validador.validarEmail(valor))
                this.valor = valor.trim().toUpperCase();;
        }
        else if (this.tipo == ContatoEnum.TELEFONE){
            if (Validador.validarTelefone(valor))
                // SALVA APENAS OS NUMEROS, SEM CARACTERES ESPECIAIS
                this.valor = valor.replaceAll("\\D", "");;
        }
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
