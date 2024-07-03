package org.example;

public class StubHumedad extends Humedad {
    private boolean alerta;

    public StubHumedad(double valor, boolean alerta) {
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


