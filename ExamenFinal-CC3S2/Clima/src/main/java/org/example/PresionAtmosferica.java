package org.example;

public class PresionAtmosferica extends Sensor{
    private static final double UMBRAL_PRESION_ALTA = 1020; //Celsius

    public PresionAtmosferica(double valor) {
        super(valor);
    }

    @Override
    public boolean verificarAlerta() {
        if (valor > UMBRAL_PRESION_ALTA) {
            alerta("Presion atmosferica Alta");
            return true;
        }
        return false;
    }

    private void alerta(String mensaje) {
        System.out.println("Alerta: " + mensaje + "!");
    }
}