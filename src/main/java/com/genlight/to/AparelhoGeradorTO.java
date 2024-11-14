package com.genlight.to;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class AparelhoGeradorTO {
    private int id;

    private int potencia;

    @NotNull
    @Max(value = 2, message = "Type should be in range 1-2 of values")
    private int tipo;

    @NotNull
    private int sitio;

    public AparelhoGeradorTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSitio() {
        return sitio;
    }

    public void setSitio(int sitio) {
        this.sitio = sitio;
    }
}
