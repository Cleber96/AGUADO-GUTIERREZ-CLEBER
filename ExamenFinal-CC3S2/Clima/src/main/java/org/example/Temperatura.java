package org.example;

public class Temperatura extends Sensor {
    private static final double UMBRAL_TEMPERATURA_ALTA = 20; // Celsius

    public Temperatura(double valor, Alerta alerta) {
        super(valor, UMBRAL_TEMPERATURA_ALTA, "Temperatura Alta","Activar sistema de riego", alerta);
    }
}
