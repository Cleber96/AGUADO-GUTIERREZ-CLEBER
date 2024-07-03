package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LLuviaTest {
    LLuvia lluvia;

    @BeforeEach
    void setUp() {
        lluvia = new LLuvia(0); // Inicializamos con 0 mm de lluvia para cada test
    }

    @AfterEach
    void tearDown() {
        lluvia = null; // Limpiar
    }

    @Test
    void verificarAlertaConLluviaIntensa() {
        lluvia.setValor(25); //desencadenar una alerta
        assertTrue(lluvia.verificarAlerta(), "Debería retornar true para lluvia intensa");
    }

    @Test
    void verificarAlertaSinLluviaIntensa() {
        lluvia.setValor(15); //no desencadenar una alerta
        assertFalse(lluvia.verificarAlerta(), "Debería retornar false para lluvia no intensa");
    }

    @Test
    void verificarAlertaEnElUmbral() {
        lluvia.setValor(20); //umbral
        assertFalse(lluvia.verificarAlerta(), "Debería retornar false porque 20 no es mayor que 20");
    }

    @Test
    void verificarAlertaPorEncimaDelUmbral() {
        lluvia.setValor(20.1); //por encima del umbral
        assertTrue(lluvia.verificarAlerta(), "Debería retornar true porque 20.1 es mayor que 20");
    }
}
