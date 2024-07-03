package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class StubPresionAtmosfericaTest {
    @ParameterizedTest
    @CsvSource({
            "1030, true",
            "1030, false",
            "1010, true",
            "1010, false"
    })
    public void testVerificarAlerta(double valor, boolean alertaEsperada) {
        StubPresionAtmosferica stubPresionAtmosferica = new StubPresionAtmosferica(valor, alertaEsperada);
        assertEquals(alertaEsperada, stubPresionAtmosferica.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}