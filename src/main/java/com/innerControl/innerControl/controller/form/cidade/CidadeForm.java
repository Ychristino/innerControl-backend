package com.innerControl.innerControl.controller.form.cidade;

import com.innerControl.innerControl.controller.form.estado.EstadoForm;
import com.innerControl.innerControl.controller.form.pais.PaisForm;
import com.innerControl.innerControl.models.Cidade;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CidadeForm {
    private Long id;
    @NotNull(message = "Nome da cidade deve ser informado!")
    @NotEmpty(message = "Nome da cidade deve ser informado!")
    private String nome;
    private EstadoForm estado;
    private PaisForm pais;

    public Cidade toEntity(Pais pais, Estado estado) {
        Cidade cidade = new Cidade();
        cidade.setNome(this.nome);
        cidade.setEstado(estado);
        cidade.setPais(pais);
        return cidade;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoForm getEstado() {
        return estado;
    }

    public void setEstado(EstadoForm estado) {
        this.estado = estado;
    }

    public PaisForm getPais() {
        return pais;
    }

    public void setPais(PaisForm pais) {
        this.pais = pais;
    }
}
