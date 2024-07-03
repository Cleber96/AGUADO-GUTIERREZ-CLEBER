package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class FakeHumedadTest {
    FakeHumedad fakeHumedad;

    @BeforeEach
    void setUp() {
        fakeHumedad = new FakeHumedad(0, false); // Inicializamos con 0 porcentaje y sin alerta
    }

    @AfterEach
    void tearDown() {
        fakeHumedad = null; // Limpiar
    }

    @ParameterizedTest
    @CsvSource({
            "65, true",
            "55, false",
            "60, false",
            "60.1, true"
    })
    void verificarAlertaForzada(double valor, boolean alertaEsperada) {
        fakeHumedad.setValor(valor);
        fakeHumedad.setAlertaForzada(alertaEsperada);
        assertEquals(alertaEsperada, fakeHumedad.verificarAlerta(), "La alerta debería ser " + alertaEsperada);
    }
}
