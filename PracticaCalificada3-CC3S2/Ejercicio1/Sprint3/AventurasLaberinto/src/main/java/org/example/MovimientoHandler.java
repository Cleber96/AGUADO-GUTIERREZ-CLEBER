package org.example;

public class MovimientoHandler {
    public void mover(char direccion, Jugador jugador, Laberinto laberinto) {
        Posicion nuevaPosicion = calcularNuevaPosicion(direccion, jugador.getPosicion());
        if (!jugador.verificarColision(nuevaPosicion)) {
            Celda nuevaCelda = laberinto.getTablero()[nuevaPosicion.getFila()][nuevaPosicion.getColumna()];
            if(jugador.verificarTrampa(nuevaCelda)) {
                System.out.println("Ten cuidado ¡trampa! Pierdes una vida");
            }
            jugador.recogerTesoro(nuevaCelda);
            laberinto.actualizarCelda(jugador.getPosicion().getFila(), jugador.getPosicion().getColumna(), '.');
            laberinto.actualizarCelda(nuevaPosicion.getFila(), nuevaPosicion.getColumna(),'P');
            jugador.mover(nuevaPosicion);
        }
    }

    private Posicion calcularNuevaPosicion(char direccion, Posicion posicionActual) {
        int fila = posicionActual.getFila();
        int columna = posicionActual.getColumna();
        switch (direccion) {
            case 'N': return new Posicion(fila - 1, columna);
            case 'S': return new Posicion(fila + 1, columna);
            case 'E': return new Posicion(fila, columna + 1);
            case 'O': return new Posicion(fila, columna - 1);
            default: return new Posicion(-1, -1);
        }
    }
}

