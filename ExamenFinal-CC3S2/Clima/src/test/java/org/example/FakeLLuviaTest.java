package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FakeLLuviaTest {
    FakeLLuvia fakeLLuvia;

    @BeforeEach
    void setUp() {
        fakeLLuvia = new FakeLLuvia(0, false); // Inicializamos con 0 mm y sin alerta
    }

    @AfterEach
    void tearDown() {
        fakeLLuvia = null; // Limpiar
    }

    @ParameterizedTest
    @CsvSource({
            "25, true",
            "15, false",
            "20, false",
            "20.1, true"
    })
    void verificarAlertaForzada(double valor, boolean alertaEsperada) {
        fakeLLuvia.setValor(valor);
        fakeLLuvia.setAlertaForzada(alertaEsperada);
        assertEquals(alertaEsperada, fakeLLuvia.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}
