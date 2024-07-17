package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    private Project project;

    @BeforeEach
    public void setUp() {
        project = new Project("Desarrollo de IA", "Desarrollando módulos de IA", LocalDate.now(), LocalDate.now().plusMonths(3));
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Desarrollo de IA", project.getName());
        project.setName("Nuevo Proyecto");
        assertEquals("Nuevo Proyecto", project.getName());

        assertEquals("Desarrollando módulos de IA", project.getDescription());
        project.setDescription("Nueva Descripción");
        assertEquals("Nueva Descripción", project.getDescription());

        assertEquals(LocalDate.now(), project.getStartDate());
        project.setStartDate(LocalDate.now().minusDays(1));
        assertEquals(LocalDate.now().minusDays(1), project.getStartDate());

        assertEquals(LocalDate.now().plusMonths(3), project.getEndDate());
        project.setEndDate(LocalDate.now().plusMonths(4));
        assertEquals(LocalDate.now().plusMonths(4), project.getEndDate());
    }
}
