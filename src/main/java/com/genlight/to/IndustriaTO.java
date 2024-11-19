package com.genlight.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IndustriaTO {
    private int id;

    @NotBlank(message = "Name can't be blank")
    private String nome;

    @NotNull(message = "Industry should be linked with a enterprise")
    private int idEmpresa;



    public IndustriaTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
