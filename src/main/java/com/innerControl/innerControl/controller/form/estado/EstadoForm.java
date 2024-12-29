package com.innerControl.innerControl.controller.form.estado;

import com.innerControl.innerControl.controller.form.pais.PaisForm;
import com.innerControl.innerControl.models.Estado;
import com.innerControl.innerControl.models.Pais;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EstadoForm {
    private Long id;
    @NotNull(message = "Nome do estado deve ser informado!")
    @NotEmpty(message = "Nome do estado deve ser informado!")
    private String nome;
    @NotNull(message = "Sigla do estado deve ser informada!")
    @NotEmpty(message = "Sigla do estado deve ser informada!")
    private String sigla;
    private PaisForm pais;

    public Estado toEntity(Pais pais) {
        Estado estado = new Estado();
        estado.setNome(this.nome);
        estado.setSigla(this.sigla);
        estado.setPais(pais);
        return estado;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public PaisForm getPais() {
        return pais;
    }

    public void setPais(PaisForm pais) {
        this.pais = pais;
    }
}
