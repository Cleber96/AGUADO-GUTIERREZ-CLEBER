package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumedadTest {
    Humedad humedad;
    Alerta alerta;

    @BeforeEach
    void setUp() {
        alerta = new AlertaPorUmbral();
        humedad = new Humedad(0, alerta); // Inicializamos con 0 porcentaje
    }

    @AfterEach
    void tearDown() {
        humedad = null; // Limpiar
    }

    @Test
    void verificarAlertaConHumedadAlta() {
        humedad.setValor(65); //desencadenar una alerta
        assertTrue(humedad.verificarAlerta(), "Debería retornar true para humedad alta");
    }

    @Test
    void verificarAlertaSinHumedadAlta() {
        humedad.setValor(55); //no desencadenar una alerta
        assertFalse(humedad.verificarAlerta(), "Debería retornar false para humedad alta");
    }

    @Test
    void verificarAlertaEnElUmbral() {
        humedad.setValor(60); //umbral
        assertFalse(humedad.verificarAlerta(), "Debería retornar false porque 60 no es mayor que 60");
    }

    @Test
    void verificarAlertaPorEncimaDelUmbral() {
        humedad.setValor(60.1); //por encima del umbral
        assertTrue(humedad.verificarAlerta(), "Debería retornar true porque 60.1 es mayor que 60");
    }
}