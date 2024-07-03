package org.example;

public class Humedad extends Sensor {
    private static final double UMBRAL_HUMEDAD_ALTA = 60; // Celsius

    public Humedad(double valor, Alerta alerta) {
        super(valor, UMBRAL_HUMEDAD_ALTA, "Humedad Alta", "Activar calefacción", alerta);
    }
}
