package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class StubTemperaturaTest {
    @ParameterizedTest
    @CsvSource({
            "25, true",
            "25, false",
            "15, true",
            "15, false"
    })
    public void testVerificarAlerta(double valor, boolean alertaEsperada) {
        StubTemperatura stubTemperatura = new StubTemperatura(valor, alertaEsperada);
        assertEquals(alertaEsperada, stubTemperatura.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}