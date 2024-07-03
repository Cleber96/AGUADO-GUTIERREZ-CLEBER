package org.example;

public class LLuvia extends Sensor {
    private static final double UMBRAL_LLUVIA_INTENSA = 20; // mm

    public LLuvia(double valor, Alerta alerta) {
        super(valor, UMBRAL_LLUVIA_INTENSA, "Lluvia Intensa","Cerrar ventanas", alerta);
    }
}
