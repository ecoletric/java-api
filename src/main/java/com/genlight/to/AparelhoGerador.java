package com.genlight.to;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class AparelhoGerador {
    private int id;

    private int potencia;
    @Max(value = 1, message = "Type should be in range 0-1 of values")
    private int tipo;

    @NotNull
    private int sitio;

    public AparelhoGerador() {
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
