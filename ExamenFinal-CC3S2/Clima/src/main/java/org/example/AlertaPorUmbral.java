package org.example;

public class AlertaPorUmbral implements Alerta {
    @Override
    public boolean verificar(double valor, double umbral) {
        return valor > umbral;
    }
}