package org.example;

import java.util.Random;

public class Laberinto implements Tablero{
    private static final int TAMANO = 10;
    private Celda[][] tablero;
    LaberintoGenerico laberintoGenerico;

    public Posicion iniciar() {
        this.tablero = new Celda[TAMANO][TAMANO];
        laberintoGenerico = new LaberintoGenerico(tablero, TAMANO);
        laberintoGenerico.llenarTableroConElementos();
        return laberintoGenerico.colocarJugadorEnTablero();
    }

    @Override
    public void mostrar() {
        System.out.println("\nMOSTRANDO LABERINTO");
        for (Celda[] fila : tablero) {
            for (Celda celda : fila) {
                System.out.print(celda.obtenerTipo() + " ");
            }
            System.out.println();
        }
    }
    @Override
    public void actualizarCelda(int fila, int columna, char nuevoTipo) {
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



