package org.example;

public class StubPresionAtmosferica extends PresionAtmosferica {
    private boolean alerta;
    public StubPresionAtmosferica(double valor, boolean alerta) {
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
