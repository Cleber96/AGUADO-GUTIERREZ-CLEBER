package org.example;

import java.util.Random;

public class LaberintoGenerico implements LaberintoGenerator{
    int TAMANO;
    Celda[][] tablero;
    Random rand;
    public LaberintoGenerico(Celda[][] tablero, int TAMANO) {
        this.TAMANO = TAMANO;
        this.tablero = tablero;
        rand = new Random();
    }
    @Override
    public void llenarTableroConElementos() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = new Celda(colocarTesoroTrampa());
            }
        }
    }
    @Override
    public char colocarTesoroTrampa() {
        switch (rand.nextInt(3)) {
            case 0: return '.';
            case 1: return 'T';
            case 2: return 'X';
            default: throw new IllegalStateException("Valor aleatorio fuera de rango");
        }
    }
    @Override
    public Posicion colocarJugadorEnTablero() {
        int fila = rand.nextInt(TAMANO);
        int columna = rand.nextInt(TAMANO);
        tablero[fila][columna] = new Celda('P');
        return new Posicion(fila, columna);
    }
}
