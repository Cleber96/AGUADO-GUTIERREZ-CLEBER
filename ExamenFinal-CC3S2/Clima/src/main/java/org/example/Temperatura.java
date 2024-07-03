package org.example;

public class Temperatura extends Sensor {
    private static final double UMBRAL_TEMPERATURA_ALTA = 20; //Celsius

    public Temperatura(double valor) {
        super(valor);
    }

    @Override
    public boolean verificarAlerta() {
        if (valor > UMBRAL_TEMPERATURA_ALTA) {
            alerta("Temperatura Alta");
            return true;
        }
        return false;
    }

    private void alerta(String mensaje) {
        System.out.println("Alerta: " + mensaje + "!");
    }
}
