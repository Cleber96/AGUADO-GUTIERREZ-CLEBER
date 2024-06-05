package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CeldaTest {
    char tipoInicial = 'X';
    Celda celda;
    @BeforeEach
    public void setUp() {
        celda = new Celda(tipoInicial);
    }

    @Test
    public void testCrearCelda() {
        assertThat(celda).isNotNull();
        assertThat(celda.obtenerTipo()).isEqualTo(tipoInicial);
    }

    @Test
    public void testObtenerTipoCelda() {
        assertThat(celda.obtenerTipo()).isEqualTo(tipoInicial);
    }
}
