package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MethodTest {
    @Test
    public void testConstructorAndGetters() {
        String name = "testMethod";
        Set<String> attributes = new HashSet<>(Arrays.asList("attr1", "attr2"));
        Method method = new Method(name, attributes);
        assertEquals(name, method.getName(), "getName() debe devolver el nombre del método");
        assertEquals(attributes, method.getAttributes(), "getAttributes() debe devolver el conjunto de atributos");
    }

    @Test
    public void testConstructorWithNullName() {
        try {
            Set<String> attributes = new HashSet<>(Arrays.asList("attr1", "attr2"));
            new Method(null, attributes);
            fail("Se esperaba una excepción NullPointerException");
        } catch (NullPointerException e) {
            // La excepción esperada fue lanzada, la prueba pasa
        }
    }

    @Test
    public void testConstructorWithNullAttributes() {
        try {
            new Method("testMethod", null);
            fail("Se esperaba una excepción NullPointerException");
        } catch (NullPointerException e) {
            // La excepción esperada fue lanzada, la prueba pasa
        }
    }

    @Test
    public void testConstructorWithEmptyAttributes() {
        Set<String> attributes = new HashSet<>();
        Method method = new Method("testMethod", attributes);
        assertTrue(method.getAttributes().isEmpty(), "Los atributos deben ser una lista vacía");
    }

    @Test
    public void testConstructorEmptyAttributes() {
        Set<String> attributes = new HashSet<>();
        Method method = new Method("testMethod", attributes);
        assertTrue(method.getAttributes().isEmpty(), "Los atributos deben ser una lista vacía");
    }
}
