package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresionAtmosfericaTest {
    PresionAtmosferica presionAtmosferica;  //hPa

    @BeforeEach
    void setUp() {
        presionAtmosferica = new PresionAtmosferica(0); // Inicializamos con 0 hPa
    }

    @AfterEach
    void tearDown() {
        presionAtmosferica = null; // Limpiar
    }

    @Test
    void verificarAlertaConHumedadAlta() {
        presionAtmosferica.setValor(1025); //desencadenar una alerta
        assertTrue(presionAtmosferica.verificarAlerta(), "Debería retornar true para alta presion atmosferica");
    }

    @Test
    void verificarAlertaSinHumedadAlta() {
        presionAtmosferica.setValor(1015); //no desencadenar una alerta
        assertFalse(presionAtmosferica.verificarAlerta(), "Debería retornar false para alta presion atmosferica");
    }

    @Test
    void verificarAlertaEnElUmbral() {
        presionAtmosferica.setValor(1020); //umbral
        assertFalse(presionAtmosferica.verificarAlerta(), "Debería retornar false porque 1020 no es mayor que 1020");
    }

    @Test
    void verificarAlertaPorEncimaDelUmbral() {
        presionAtmosferica.setValor(1020.1); //por encima del umbral
        assertTrue(presionAtmosferica.verificarAlerta(), "Debería retornar true porque 1020.1 es mayor que 1020");
    }
}