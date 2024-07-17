package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Diseñar IA", "Diseñar la arquitectura de IA", "Jane Doe", "Pendiente", LocalDate.now().plusDays(10));
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Diseñar IA", task.getTitle());
        task.setTitle("Nuevo Título");
        assertEquals("Nuevo Título", task.getTitle());

        assertEquals("Diseñar la arquitectura de IA", task.getDescription());
        task.setDescription("Nueva Descripción");
        assertEquals("Nueva Descripción", task.getDescription());

        assertEquals("Jane Doe", task.getAssignedTo());
        task.setAssignedTo("John Doe");
        assertEquals("John Doe", task.getAssignedTo());

        assertEquals("Pendiente", task.getStatus());
        task.setStatus("Completado");
        assertEquals("Completado", task.getStatus());

        assertEquals(LocalDate.now().plusDays(10), task.getDueDate());
        task.setDueDate(LocalDate.now().plusDays(5));
        assertEquals(LocalDate.now().plusDays(5), task.getDueDate());
    }

    @Test
    public void testAssignTask() {
        task.setAssignmentStrategy(new SimpleTaskAssignmentStrategy());
        task.assignTask();
        assertEquals("Asignado automáticamente", task.getAssignedTo());
    }

    @Test
    public void testAssignTaskWithNoStrategy() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, task::assignTask);
        assertEquals("No se ha especificado una estrategia de asignación", thrown.getMessage());
    }
}
