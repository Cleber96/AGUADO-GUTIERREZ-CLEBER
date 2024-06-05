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
        assertEquals('P', juego.laberinto.getTablero()[posicionInicial.getFila()][posicionInicial.getColumna()].obtenerTipo());
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
        Celda[][] tablero = juego.laberinto.getTablero();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                juego.laberinto.actualizarCelda(juego.laberinto.getTablero(), i, j, '.');
            }
        }
        juego.laberinto.setTablero(tablero);
        assertFalse(juego.verificarEstado());
    }

    @Test
    public void testActulizarEstado_VidaPositivaYConTesoro() {
        assertTrue(juego.actulizarEstado());
    }

    @Test
    public void testActulizarEstado_SinVida() {
        juego.jugador.setVida(0);
        assertFalse(juego.actulizarEstado());
        assertEquals("PERDISTE", juego.verificarVicDerr());
    }

    @Test
    public void testActulizarEstado_SinTesoros() {
        Celda[][] tablero = juego.laberinto.getTablero();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                juego.laberinto.actualizarCelda(juego.laberinto.getTablero(), i, j, '.');
            }
        }
        juego.laberinto.setTablero(tablero);
        assertFalse(juego.actulizarEstado());
        assertEquals("GANASTE", juego.verificarVicDerr());
    }

    @Test
    public void testVerificarVicDerr_Ganaste() {
        Celda[][] tablero = juego.laberinto.getTablero();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                juego.laberinto.actualizarCelda(juego.laberinto.getTablero(), i, j, '.');
            }
        }
        juego.laberinto.setTablero(tablero);
        assertEquals("GANASTE", juego.verificarVicDerr());
    }

    @Test
    public void testVerificarVicDerr_Perdite() {
        juego.jugador.setVida(0);
        assertEquals("PERDISTE", juego.verificarVicDerr());
    }
}

