package com.genlight.to;

public enum TipoEnergia {
    PRODUCAO_INDUSTRIAL(0),
    ENERGIA_SOLAR(1),
    ENERGIA_EOLICA(2);

    private final int valor;

    TipoEnergia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoEnergia fromValor(int valor) {
        for (TipoEnergia tipo : TipoEnergia.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor desconhecido: " + valor);
    }
}
