package com.genlight.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Endereco {
    private int id;
    @Size(min = 8, max = 8, message = "Invalid CEP/Zip Code")
    private String cep;

    @NotBlank(message = "Name can't be null")
    private String nome;

    private String complemento;

    public Endereco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
