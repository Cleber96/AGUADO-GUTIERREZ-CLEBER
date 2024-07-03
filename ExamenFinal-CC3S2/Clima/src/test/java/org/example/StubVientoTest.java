package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class StubVientoTest {
    @ParameterizedTest
    @CsvSource({
            "60, true",
            "40, false",
            "50, true",
            "30, false"
    })
    public void testVerificarAlerta(double valor, boolean alertaEsperada) {
        StubViento stubViento = new StubViento(valor, alertaEsperada);
        assertEquals(alertaEsperada, stubViento.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }

}