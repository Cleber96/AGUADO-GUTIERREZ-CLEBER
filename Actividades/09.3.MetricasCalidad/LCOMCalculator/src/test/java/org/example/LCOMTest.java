package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class LCOMTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    ClassInfo classInfo;
    LCOM lcom;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        classInfo = new ClassInfo();
        lcom = new LCOM();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testCalcLCOM_NoSharedAttributes() {
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr3")));
        lcom.calcLCOM(classInfo);
        assertEquals("LCOM = 1\n", outputStreamCaptor.toString());
    }

    @Test
    public void testCalcLCOM_SharedAttributes() {
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2", "attr3")));
        lcom.calcLCOM(classInfo);
        assertEquals("LCOM = -1\n", outputStreamCaptor.toString());
    }

    @Test
    public void testCalcLCOM_EmptyClassInfo() {
        lcom.calcLCOM(classInfo);
        assertEquals("LCOM = 0\n", outputStreamCaptor.toString());
    }
}
