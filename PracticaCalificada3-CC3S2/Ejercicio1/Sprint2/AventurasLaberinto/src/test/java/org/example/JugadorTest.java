package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {
    private Jugador jugador;
    private Posicion posicionInicial;
    private Posicion posicionValida;
    private Posicion posicionInvalida1;
    private Posicion posicionInvalida2;

    @BeforeEach
    public void setUp() {
        jugador = new Jugador();
        posicionInicial = new Posicion(0, 0);
        posicionValida = new Posicion(5, 5);
        posicionInvalida1 = new Posicion(-1, 5);
        posicionInvalida2 = new Posicion(10, 10);
        jugador.setPosicion(posicionInicial);
    }

    @Test
    public void testVerificarColision() {
        assertThat(jugador.verificarColision(posicionValida)).isFalse();
        assertThat(jugador.verificarColision(posicionInvalida1)).isTrue();
        assertThat(jugador.verificarColision(posicionInvalida2)).isTrue();
    }

    @Test
    public void testActualizarPosicionValida() {
        jugador.actualizarPosicion(posicionValida);
        assertTrue(jugador.getPosicion().equals(posicionValida));
    }

    @Test
    public void testActualizarPosicionInvalida() {
        jugador.actualizarPosicion(posicionInvalida1);
        assertFalse(jugador.getPosicion().equals(posicionInvalida1));
    }

    @Test
    public void testMoverValido() {
        jugador.mover(posicionValida);
        assertThat(jugador.getPosicion()).isEqualTo(posicionValida);
    }

    @Test
    public void testMoverInvalido() {
        jugador.mover(posicionInvalida1);
        assertThat(jugador.getPosicion()).isEqualTo(posicionInicial);
    }

    @Test
    public void testRecogerTesoro() {
        Celda tesoro = new Celda('T');
        int puntajeInicial = jugador.getPuntaje();
        jugador.recogerTesoro(tesoro);
        assertThat(jugador.getPuntaje()).isEqualTo(puntajeInicial + 1);
    }

    @Test
    public void testNoRecogerTesoro() {
        Celda noTesoro = new Celda('.');
        int puntajeInicial = jugador.getPuntaje();
        jugador.recogerTesoro(noTesoro);
        assertThat(jugador.getPuntaje()).isEqualTo(puntajeInicial);
    }

    @Test
    public void testVerificarTrampa() {
        Celda trampa = new Celda('X');
        int vidaInicial = jugador.getVida();
        assertTrue(jugador.verificarTrampa(trampa));
        assertThat(jugador.getVida()).isEqualTo(vidaInicial - 1);
    }

    @Test
    public void testNoVerificarTrampa() {
        Celda noTrampa = new Celda('.');
        int vidaInicial = jugador.getVida();
        assertFalse(jugador.verificarTrampa(noTrampa));
        assertThat(jugador.getVida()).isEqualTo(vidaInicial);
    }

    @Test
    public void testSetPosicionNoNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            jugador.setPosicion(null);
        });
    }

    @Test
    public void testSetPuntajeNoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            jugador.setPuntaje(-1);
        });
    }

    @Test
    public void testSetVidaNoNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            jugador.setVida(-1);
        });
    }
}



