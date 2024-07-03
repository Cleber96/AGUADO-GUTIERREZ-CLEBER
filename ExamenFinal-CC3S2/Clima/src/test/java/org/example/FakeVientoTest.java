package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FakeVientoTest {
    FakeViento fakeViento;

    @BeforeEach
    void setUp() {
        fakeViento = new FakeViento(0, false); // Inicializamos con 0 km/h y sin alerta
    }

    @AfterEach
    void tearDown() {
        fakeViento = null; // Limpiar
    }

    @ParameterizedTest
    @CsvSource({
            "60, true",
            "40, false",
            "50, false",
            "50.1, true"
    })
    void verificarAlertaForzada(double valor, boolean alertaEsperada) {
        fakeViento.setValor(valor);
        fakeViento.setAlertaForzada(alertaEsperada);
        assertEquals(alertaEsperada, fakeViento.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}
