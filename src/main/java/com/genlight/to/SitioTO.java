package com.genlight.to;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class SitioTO {
    private int id;

    @NotNull(message = "Name can't be null")
    private String nome;

    @Max(value = 2, message = "Energy type should be only 0-1 range values!")
    private int tipoFonte;
    @NotNull(message = "idIndustria can't be null")
    private int idIndustria;
    @NotNull(message = "idEndereco can't be null")
    private int idEndereco;

    private Double consumo;
    private Double energiaProduzida;



    public SitioTO() {
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

    public int getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(int tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public int getIdIndustria() {
        return idIndustria;
    }

    public void setIdIndustria(int idIndustria) {
        this.idIndustria = idIndustria;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getEnergiaProduzida() {
        return energiaProduzida;
    }

    public void setEnergiaProduzida(Double energiaProduzida) {
        this.energiaProduzida = energiaProduzida;
    }
}


