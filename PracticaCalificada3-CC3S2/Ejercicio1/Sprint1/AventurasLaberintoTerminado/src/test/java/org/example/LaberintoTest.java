package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LaberintoTest {
    private Laberinto laberinto;

    @BeforeEach
    public void setUp() {
        laberinto = new Laberinto();
    }

    @Test
    public void testIniciar() {
        Posicion posicionInicial = laberinto.iniciar();
        char[][] tablero = laberinto.getTablero();

        assertThat(tablero).isNotNull();
        assertThat(tablero.length).isEqualTo(10);
        for (int i = 0; i < tablero.length; i++) {
            assertThat(tablero[i].length).isEqualTo(10);
        }

        boolean foundP = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                char cell = tablero[i][j];
                assertThat(cell).isIn('.', 'T', 'X', 'P');
                if (cell == 'P') {
                    assertThat(posicionInicial.getFila()).isEqualTo(i);
                    assertThat(posicionInicial.getColumna()).isEqualTo(j);
                    foundP = true;
                }
            }
        }
        assertThat(foundP).isTrue();
    }
}

