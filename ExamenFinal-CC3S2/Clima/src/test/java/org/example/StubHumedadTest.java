package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class StubHumedadTest {
    @ParameterizedTest
    @CsvSource({
            "65, true",
            "65, false",
            "55, true",
            "55, false"
    })
    public void testVerificarAlerta(double valor, boolean alertaEsperada) {
        StubHumedad stubHumedad = new StubHumedad(valor, alertaEsperada);
        assertEquals(alertaEsperada, stubHumedad.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}