package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FakeTemperaturaTest {
    FakeTemperatura fakeTemperatura;

    @BeforeEach
    void setUp() {
        fakeTemperatura = new FakeTemperatura(0, false); // Inicializamos con 0 grados y sin alerta
    }

    @AfterEach
    void tearDown() {
        fakeTemperatura = null; // Limpiar
    }

    @ParameterizedTest
    @CsvSource({
            "25, true",
            "15, false",
            "20, false",
            "20.1, true"
    })
    void verificarAlertaForzada(double valor, boolean alertaEsperada) {
        fakeTemperatura.setValor(valor);
        fakeTemperatura.setAlertaForzada(alertaEsperada);
        assertEquals(alertaEsperada, fakeTemperatura.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}
