package org.example;

public class StubViento extends Viento {
    private boolean alerta;

    public StubViento(double valor, boolean alerta) {
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