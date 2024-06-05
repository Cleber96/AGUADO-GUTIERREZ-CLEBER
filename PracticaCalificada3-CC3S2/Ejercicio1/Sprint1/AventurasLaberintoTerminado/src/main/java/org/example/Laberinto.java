package org.example;

import java.util.Random;

public class Laberinto {
    private static final int TAMANO = 10;
    private char[][] tablero;

    public Posicion iniciar() {
        this.tablero = new char[TAMANO][TAMANO];
        llenarTableroConElementos();
        return colocarJugadorEnTablero();
    }

    private void llenarTableroConElementos() {
        Random rand = new Random();
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = generarElementoAleatorio(rand);
            }
        }
    }

    private char generarElementoAleatorio(Random rand) {
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
        tablero[fila][columna] = 'P';
        return new Posicion(fila, columna);
    }

    public void mostrar() {
        System.out.println("\nMOSTRANDO LABERINTO");
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public int getTAMANO() {
        return TAMANO;
    }
}



