package org.example;

public class Viento extends Sensor {
    private static final double UMBRAL_VIENTO_FUERTE = 50; // km/h

    public Viento(double valor, Alerta alerta) {
        super(valor, UMBRAL_VIENTO_FUERTE, "Viento Fuerte","Cerra persianas", alerta);
    }
}

