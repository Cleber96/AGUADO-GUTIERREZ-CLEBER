package org.example;

public class Humedad extends Sensor{
    private static final double UMBRAL_HUMEDAD_ALTA = 60; //Celsius

    public Humedad(double valor) {
        super(valor);
    }

    @Override
    public boolean verificarAlerta() {
        if (valor > UMBRAL_HUMEDAD_ALTA) {
            alerta("Humedad Alta");
            return true;
        }
        return false;
    }

    private void alerta(String mensaje) {
        System.out.println("Alerta: " + mensaje + "!");
    }
}
