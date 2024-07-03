package org.example;

public abstract class Sensor {
    protected double valor;

    public Sensor(double valor) {
        this.valor = valor;
    }

    // Método abstracto que debe ser implementado por cada sensor específico
    public abstract boolean verificarAlerta();

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

