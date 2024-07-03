package org.example;

public abstract class Sensor {
    protected double valor;
    private double umbral;
    private String mensajeAlerta;
    private String auxiliar;
    private Alerta alerta;

    public Sensor(double valor, double umbral, String mensajeAlerta, String auxiliar, Alerta alerta) {
        this.valor = valor;
        this.umbral = umbral;
        this.mensajeAlerta = mensajeAlerta;
        this.auxiliar = auxiliar;
        this.alerta = alerta;
    }

    public boolean verificarAlerta() {
        return alerta.verificar(valor, umbral);
    }

    public String getAuxiliar() {
        return auxiliar;
    }

    public String getMensajeAlerta() {
        return mensajeAlerta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}


