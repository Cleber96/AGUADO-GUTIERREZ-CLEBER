package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ClassInfoTest {
    private ClassInfo classInfo;
    Set<String> attrs1;
    Set<String> attrs2;

    @BeforeEach
    public void setUp() {
        classInfo = new ClassInfo();
        attrs1 = new HashSet<>(Arrays.asList("attr1", "attr2"));
        attrs2 = new HashSet<>(Arrays.asList("attr3", "attr4"));
    }

    @Test
    public void testAddMethod() {
        assertEquals(0, classInfo.getMethods().size(), "No debe haber método agregado");
        assertEquals(0, classInfo.getAttributes().size(), "No debe haber atributos agregados");

        classInfo.addMethod("method1", attrs1);
        assertEquals(1, classInfo.getMethods().size(), "Debe haber un método agregado");
        assertEquals(2, classInfo.getAttributes().size(), "Debe haber dos atributos agregados");

        classInfo.addMethod("method2", attrs2);
        assertEquals(2, classInfo.getMethods().size(), "Debe haber dos métodos agregados");
        assertEquals(4, classInfo.getAttributes().size(), "Debe haber cuatro atributos agregados");
    }

    @Test
    public void testGetMethods() {
        classInfo.addMethod("method1", attrs1);
        classInfo.addMethod("method2", attrs2);

        List<Method> methods = classInfo.getMethods();
        assertEquals(2, methods.size(), "Debe haber dos métodos en la lista");
        assertEquals("method1", methods.get(0).getName(), "El primer método debe tener nombre 'method1'");
        assertEquals("method2", methods.get(1).getName(), "El segundo método debe tener nombre 'method2'");
    }

    @Test
    public void testGetAttributes() {
        classInfo.addMethod("method1", attrs1);
        classInfo.addMethod("method2", attrs2);

        Set<String> attributes = classInfo.getAttributes();
        assertEquals(4, attributes.size(), "Debe haber cuatro atributos en el conjunto");
        assertTrue(attributes.contains("attr1"), "El conjunto debe contener 'attr1'");
        assertTrue(attributes.contains("attr2"), "El conjunto debe contener 'attr2'");
        assertTrue(attributes.contains("attr3"), "El conjunto debe contener 'attr3'");
        assertTrue(attributes.contains("attr4"), "El conjunto debe contener 'attr4'");
    }
}
