package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    private Juego juego;

    @BeforeEach
    public void setUp() {
        juego = new Juego();
        juego.iniciar();
    }

    @Test
    public void testIniciar() {
        Posicion posicionInicial = juego.jugador.getPosicion();
        assertNotNull(posicionInicial);
        assertEquals('P', juego.laberinto.getTablero()[posicionInicial.getFila()][posicionInicial.getColumna()]);
    }

    @Test
    public void testProcesarComando_Norte() {
        Posicion posicionInicial = juego.jugador.getPosicion();
        juego.procesarComando('N');
        Posicion nuevaPosicion = juego.jugador.getPosicion();
        if (posicionInicial.getFila() > 0) {
            assertEquals(posicionInicial.getFila() - 1, nuevaPosicion.getFila());
        } else {
            assertEquals(posicionInicial.getFila(), nuevaPosicion.getFila());
        }
    }

    @Test
    public void testProcesarComando_Sur() {
        Posicion posicionInicial = juego.jugador.getPosicion();
        juego.procesarComando('S');
        Posicion nuevaPosicion = juego.jugador.getPosicion();
        if (posicionInicial.getFila() < 9) {
            assertEquals(posicionInicial.getFila() + 1, nuevaPosicion.getFila());
        } else {
            assertEquals(posicionInicial.getFila(), nuevaPosicion.getFila());
        }
    }

    @Test
    public void testProcesarComando_Este() {
        Posicion posicionInicial = juego.jugador.getPosicion();
        juego.procesarComando('E');
        Posicion nuevaPosicion = juego.jugador.getPosicion();
        if (posicionInicial.getColumna() < 9) {
            assertEquals(posicionInicial.getColumna() + 1, nuevaPosicion.getColumna());
        } else {
            assertEquals(posicionInicial.getColumna(), nuevaPosicion.getColumna());
        }
    }

    @Test
    public void testProcesarComando_Oeste() {
        Posicion posicionInicial = juego.jugador.getPosicion();
        juego.procesarComando('O');
        Posicion nuevaPosicion = juego.jugador.getPosicion();
        if (posicionInicial.getColumna() > 0) {
            assertEquals(posicionInicial.getColumna() - 1, nuevaPosicion.getColumna());
        } else {
            assertEquals(posicionInicial.getColumna(), nuevaPosicion.getColumna());
        }
    }

    @Test
    public void testVerificarEstado() {
        assertTrue(juego.verificarEstado());
        char[][] tablero = juego.laberinto.getTablero();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '.';
            }
        }
        juego.laberinto.setTablero(tablero);
        assertFalse(juego.verificarEstado());
    }
}
