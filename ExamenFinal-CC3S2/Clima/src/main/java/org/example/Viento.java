package org.example;

public class Viento extends Sensor {
    private static final double UMBRAL_VIENTO_FUERTE = 50; //km/h

    public Viento(double valor) {
        super(valor);
    }

    @Override
    public boolean verificarAlerta() {
        if (valor > UMBRAL_VIENTO_FUERTE) {
            alerta("Viento Fuerte");
            return true;
        }
        return false;
    }

    private void alerta(String mensaje) {
        System.out.println("Alerta: " + mensaje + "!");
    }
}

