package com.innerControl.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisicas;

    @Column(name = "valorServico")
    private float valorServico;

    @ManyToMany
    @JoinTable(name = "servico_produto",
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;

    public Servico(){}

    public Servico(PessoaFisica pessoaFisica, float valorServico, Set<Produto> produtos){
        this.pessoaFisicas = pessoaFisica;
        this.valorServico = valorServico;
        this.produtos = produtos;
    }

    public float getValorServico() {
        return valorServico;
    }

    public void setValorServico(float valorServico) {
        this.valorServico = valorServico;
    }

    public Long getId() {
        return id;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(PessoaFisica pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
