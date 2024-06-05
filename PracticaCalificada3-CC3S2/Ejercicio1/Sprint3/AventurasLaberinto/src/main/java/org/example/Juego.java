package org.example;

import java.util.Scanner;

public class Juego {
    private final Laberinto laberinto;
    private final Jugador jugador;
    private final MovimientoHandler movimientoHandler;
    private final EstadoHandler estadoHandler;

    public Juego(Laberinto laberinto, Jugador jugador, MovimientoHandler movimientoHandler, EstadoHandler estadoHandler) {
        this.laberinto = laberinto;
        this.jugador = jugador;
        this.movimientoHandler = movimientoHandler;
        this.estadoHandler = estadoHandler;
    }

    public void iniciar() {
        Posicion posicionJugador = laberinto.iniciar();
        jugador.setPosicion(posicionJugador);
    }

    public void procesarComando(char direccion) {
        movimientoHandler.mover(direccion, jugador, laberinto);
    }

    public boolean actulizarEstado() {
        boolean estado = estadoHandler.verificarEstado(laberinto, jugador);
        if (!estado) {
            System.out.println(estadoHandler.verificarVicDerr(jugador));
        }
        return estado;
    }

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto();
        Jugador jugador = new Jugador();
        MovimientoHandler movimientoHandler = new MovimientoHandler();
        EstadoHandler estadoHandler = new EstadoHandler();

        Juego juego = new Juego(laberinto, jugador, movimientoHandler, estadoHandler);
        juego.iniciar();
        juego.laberinto.mostrar();
        Scanner in = new Scanner(System.in);
        while (juego.actulizarEstado()) {
            System.out.println("MENÚ\n - N: Norte\n - S: Sur\n - E: Este\n - O: Oeste");
            System.out.print("Ingrese movimiento (letra): ");
            char direccion = in.next().charAt(0);
            juego.procesarComando(direccion);
            System.out.println("\tPUNTAJE ACTUAL : (" + juego.jugador.getPuntaje() + ")");
            System.out.println("\tVIDA ACTUAL : (" + juego.jugador.getVida() + ")");
            System.out.println("\tPOSICION ACTUAL : (" + juego.jugador.getPosicion().getFila() + "," + juego.jugador.getPosicion().getColumna() + ")\n");
            juego.laberinto.mostrar();
        }
        in.close();
    }
}

