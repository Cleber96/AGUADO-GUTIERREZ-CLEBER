package org.example;

import java.util.Scanner;

public class Juego {
    public Laberinto laberinto = new Laberinto();
    public Jugador jugador = new Jugador();

    public void iniciar() {
        //funcionalidad
    }

    public void procesarComando(char direccion) {
        //funcinalidad
    }

    public boolean verificarEstado() {
        return true;
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.laberinto.mostrar();
        Scanner in = new Scanner(System.in);
        while(juego.verificarEstado()) {
            System.out.println("MENÚ\n - N: Norte\n - S: Sur\n - E: Este\n - O: Oeste");
            System.out.print("Ingrese movimiento (letra): ");
            char direccion = in.next().charAt(0);
            juego.procesarComando(direccion);
            System.out.println("\tPOSICION ACTUAL : " + juego.jugador.getPosicion() + "\n");
            juego.laberinto.mostrar();
        }
    }
}
