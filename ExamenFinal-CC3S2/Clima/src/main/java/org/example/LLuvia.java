package org.example;

    public class LLuvia extends Sensor {
        private static final double UMBRAL_LLUVIA_INTENSA = 20; //mm

    public LLuvia(double valor) {
        super(valor);
    }

    @Override
    public boolean verificarAlerta() {
        if (valor > UMBRAL_LLUVIA_INTENSA) {
            alerta("Lluvia Intensa");
            return true;
        }
        return false;
    }

    private void alerta(String mensaje) {
        System.out.println("Alerta: " + mensaje + "!");
    }
}
