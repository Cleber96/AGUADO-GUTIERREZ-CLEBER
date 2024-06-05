package org.example;

import java.util.Scanner;

public class Juego {
    public Laberinto laberinto = new Laberinto();
    public Jugador jugador = new Jugador();

    public void iniciar() {
        Posicion posicionJugador = laberinto.iniciar();
        jugador.setPosicion(posicionJugador);
    }

    public void procesarComando(char direccion) {
        Posicion nuevaPosicion = calcularNuevaPosicion(direccion);
        if (!jugador.verificarColision(nuevaPosicion)) {
            moverJugador(nuevaPosicion);
        }
    }

    private Posicion calcularNuevaPosicion(char direccion) {
        int fila = jugador.getPosicion().getFila();
        int columna = jugador.getPosicion().getColumna();
        switch (direccion) {
            case 'N': return new Posicion(fila - 1, columna);
            case 'S': return new Posicion(fila + 1, columna);
            case 'E': return new Posicion(fila, columna + 1);
            case 'O': return new Posicion(fila, columna - 1);
            default: return new Posicion(-1, -1);
        }
    }

    private void moverJugador(Posicion nuevaPosicion) {
        laberinto.getTablero()[jugador.getPosicion().getFila()][jugador.getPosicion().getColumna()] = '.';
        laberinto.getTablero()[nuevaPosicion.getFila()][nuevaPosicion.getColumna()] = 'P';
        jugador.mover(nuevaPosicion);
    }

    public boolean verificarEstado() {
        for(int i = 0; i < laberinto.getTAMANO(); i++) {
            for(int j = 0; j < laberinto.getTAMANO(); j++) {
                if(laberinto.getTablero()[i][j]=='T') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
        juego.laberinto.mostrar();
        Scanner in = new Scanner(System.in);
        while (juego.verificarEstado()) {
            System.out.println("MENÚ\n - N: Norte\n - S: Sur\n - E: Este\n - O: Oeste");
            System.out.print("Ingrese movimiento (letra): ");
            char direccion = in.next().charAt(0);
            juego.procesarComando(direccion);
            System.out.println("\tPOSICION ACTUAL : (" + juego.jugador.getPosicion().getFila() + "," + juego.jugador.getPosicion().getColumna() + ")\n");
            juego.laberinto.mostrar();
        }
    }
}
