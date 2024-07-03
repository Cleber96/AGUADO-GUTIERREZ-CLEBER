package org.example;

public class StubTemperatura extends Temperatura {
    private boolean alerta;

    public StubTemperatura(double valor, boolean alerta) {
        super(valor, new Alerta() {
            @Override
            public boolean verificar(double valor, double umbral) {
                return alerta;
            }
        });
        this.alerta = alerta;
    }

    @Override
    public boolean verificarAlerta() {
        return alerta;
    }
}