package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class VientoTest {
    Viento viento;

    @BeforeEach
    void setUp() {
        viento = new Viento(0); // Inicializamos con 0 km/h para cada test
    }

    @AfterEach
    void tearDown() {
        viento = null; // Limpiar
    }

    @Test
    void verificarAlertaConVientoFuerte() {
        viento.setValor(55); //desencadenar una alerta
        assertTrue(viento.verificarAlerta(), "Debería retornar true para viento fuerte");
    }

    @Test
    void verificarAlertaSinVientoFuerte() {
        viento.setValor(45); //no desencadenar una alerta
        assertFalse(viento.verificarAlerta(), "Debería retornar false para viento no fuerte");
    }

    @Test
    void verificarAlertaEnElUmbral() {
        viento.setValor(50); //umbral
        assertFalse(viento.verificarAlerta(), "Debería retornar false porque 50 no es mayor que 50");
    }

    @Test
    void verificarAlertaPorEncimaDelUmbral() {
        viento.setValor(50.1); //por encima del umbral
        assertTrue(viento.verificarAlerta(), "Debería retornar true porque 50.1 es mayor que 50");
    }
}
