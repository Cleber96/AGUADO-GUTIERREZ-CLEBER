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
            Celda nuevaCelda = laberinto.getTablero()[nuevaPosicion.getFila()][nuevaPosicion.getColumna()];
            if(jugador.verificarTrampa(nuevaCelda)) {
                System.out.println("Ten cuidado ¡trampa! Pierdes una vida");
            }
            jugador.recogerTesoro(nuevaCelda);
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
        laberinto.actualizarCelda(laberinto.getTablero(), jugador.getPosicion().getFila(),jugador.getPosicion().getColumna(),'.');
        laberinto.actualizarCelda(laberinto.getTablero(), nuevaPosicion.getFila(),nuevaPosicion.getColumna(),'P');
        jugador.mover(nuevaPosicion);
    }

    public boolean verificarEstado() {
        for(int i = 0; i < laberinto.getTAMANO(); i++) {
            for(int j = 0; j < laberinto.getTAMANO(); j++) {
                if(laberinto.getTablero()[i][j].obtenerTipo()=='T') {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean actulizarEstado() {
        if(verificarEstado() && jugador.getVida()>0){
            return true;
        }
        System.out.println(verificarVicDerr());
        return false;
    }
    public String verificarVicDerr() {
        String mensaje = " ";
        if(jugador.getVida()==0) {
            mensaje = "PERDISTE";
        }
        else if (!verificarEstado()) {
            mensaje = "GANASTE";
        }
        return mensaje;
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
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
    }
}
