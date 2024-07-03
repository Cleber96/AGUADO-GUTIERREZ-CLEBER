package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FakePresionAtmosfericaTest {
    FakePresionAtmosferica fakePresionAtmosferica;

    @BeforeEach
    void setUp() {
        fakePresionAtmosferica = new FakePresionAtmosferica(0, false); // Inicializamos con 0 hPa y sin alerta
    }

    @AfterEach
    void tearDown() {
        fakePresionAtmosferica = null; // Limpiar
    }

    @ParameterizedTest
    @CsvSource({
            "1030, true",
            "1010, false",
            "1020, false",
            "1020.1, true"
    })
    void verificarAlertaForzada(double valor, boolean alertaEsperada) {
        fakePresionAtmosferica.setValor(valor);
        fakePresionAtmosferica.setAlertaForzada(alertaEsperada);
        assertEquals(alertaEsperada, fakePresionAtmosferica.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}
