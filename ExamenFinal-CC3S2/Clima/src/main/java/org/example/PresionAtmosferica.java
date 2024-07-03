package org.example;

public class PresionAtmosferica extends Sensor {
    private static final double UMBRAL_PRESION_ALTA = 1020; // hPa

    public PresionAtmosferica(double valor, Alerta alerta) {
        super(valor, UMBRAL_PRESION_ALTA, "Presión Atmosférica Alta","Activar evacuación", alerta);
    }
}