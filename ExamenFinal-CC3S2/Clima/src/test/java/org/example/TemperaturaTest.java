package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TemperaturaTest {
    Temperatura temperatura;
    Alerta alerta;

    @BeforeEach
    void setUp() {
        alerta = new AlertaPorUmbral();
        temperatura = new Temperatura(0, alerta); // Inicializamos con 0 grados Celsius para cada test
    }

    @AfterEach
    void tearDown() {
        temperatura = null; // Limpiar
    }

    @Test
    void verificarAlertaConTemperaturaAlta() {
        temperatura.setValor(25); //desencadenar una alerta
        assertTrue(temperatura.verificarAlerta(), "Debería retornar true para una temperatura alta");
    }

    @Test
    void verificarAlertaSinTemperaturaAlta() {
        temperatura.setValor(15); //no desencadenar una alerta
        assertFalse(temperatura.verificarAlerta(), "Debería retornar false para una temperatura no alta");
    }

    @Test
    void verificarAlertaEnElUmbral() {
        temperatura.setValor(20); // umbral
        assertFalse(temperatura.verificarAlerta(), "Debería retornar false porque 20 no es mayor que 20");
    }

    @Test
    void verificarAlertaPorEncimaDelUmbral() {
        temperatura.setValor(20.1); //encima del umbral
        assertTrue(temperatura.verificarAlerta(), "Debería retornar true porque 20.1 es mayor que 20");
    }
}
