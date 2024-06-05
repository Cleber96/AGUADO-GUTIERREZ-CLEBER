package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LaberintoTest {
    private Laberinto laberinto;
    Posicion posicionInicial;
    Celda[][] tablero;

    @BeforeEach
    public void setUp() {
        laberinto = new Laberinto();
        posicionInicial = laberinto.iniciar();
        tablero = laberinto.getTablero();
    }

    @Test
    public void testIniciar() {


        assertThat(tablero).isNotNull();
        assertThat(tablero.length).isEqualTo(10);
        for (int i = 0; i < tablero.length; i++) {
            assertThat(tablero[i].length).isEqualTo(10);
        }

        boolean foundP = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Celda cell = tablero[i][j];
                assertThat(cell).isIn('.', 'T', 'X', 'P');
                if (cell.equals('P')) {
                    assertThat(posicionInicial.getFila()).isEqualTo(i);
                    assertThat(posicionInicial.getColumna()).isEqualTo(j);
                    foundP = true;
                }
            }
        }
        assertThat(foundP).isTrue();
    }

    @Test
    public void testActualizarCelda() {
        int fila = posicionInicial.getFila();
        int columna = posicionInicial.getColumna();

        assertThat(tablero[fila][columna].obtenerTipo()).isEqualTo('P');
        laberinto.actualizarCelda(tablero, fila, columna, '.');
        assertThat(tablero[fila][columna].obtenerTipo()).isEqualTo('.');
    }
}

