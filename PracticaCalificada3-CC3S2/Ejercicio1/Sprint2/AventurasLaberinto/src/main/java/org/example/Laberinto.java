package org.example;

import java.util.Random;

public class Laberinto {
    private static final int TAMANO = 10;
    private Celda[][] tablero;

    public Posicion iniciar() {
        this.tablero = new Celda[TAMANO][TAMANO];
        llenarTableroConElementos();
        return colocarJugadorEnTablero();
    }

    private void llenarTableroConElementos() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = new Celda(colocarTesoroTrampa());
            }
        }
    }

    private char colocarTesoroTrampa() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0: return '.';
            case 1: return 'T';
            case 2: return 'X';
            default: throw new IllegalStateException("Valor aleatorio fuera de rango");
        }
    }

    private Posicion colocarJugadorEnTablero() {
        Random rand = new Random();
        int fila = rand.nextInt(TAMANO);
        int columna = rand.nextInt(TAMANO);
        actualizarCelda(tablero,fila,columna,'P');
        return new Posicion(fila, columna);
    }

    public void mostrar() {
        System.out.println("\nMOSTRANDO LABERINTO");
        for (Celda[] fila : tablero) {
            for (Celda celda : fila) {
                System.out.print(celda.obtenerTipo() + " ");
            }
            System.out.println();
        }
    }

    public void actualizarCelda(Celda[][] tablero, int fila, int columna, char nuevoTipo) {
        tablero[fila][columna] = new Celda(nuevoTipo);
    }

    public Celda[][] getTablero() {
        return tablero;
    }

    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }

    public int getTAMANO() {
        return TAMANO;
    }
}



