package org.example;

public class StubLLuvia extends LLuvia {
    private boolean alerta;

    public StubLLuvia(double valor, boolean alerta) {
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
