package org.example;

public class FakeTemperatura extends Temperatura {
    private boolean alertaForzada;

    public FakeTemperatura(double valor, boolean alertaForzada) {
        super(valor, new Alerta() {
            @Override
            public boolean verificar(double valor, double umbral) {
                return alertaForzada;
            }
        });
        this.alertaForzada = alertaForzada;
    }

    @Override
    public boolean verificarAlerta() {
        return alertaForzada;
    }

    public void setAlertaForzada(boolean alertaForzada) {
        this.alertaForzada = alertaForzada;
    }
}
