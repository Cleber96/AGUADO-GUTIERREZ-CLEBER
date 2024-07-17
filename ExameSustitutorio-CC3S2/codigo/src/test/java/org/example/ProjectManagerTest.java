package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectManagerTest {

    private Project project;
    private ProjectManager projectManager;
    private Task task;
    private Observer observer;
    private String username;

    @BeforeEach
    public void setUp() {
        username = "admin";
        project = new Project("Desarrollo de IA", "Desarrollando módulos de IA", LocalDate.now(), LocalDate.now().plusMonths(3));
        projectManager = new ProjectManager(project);
        task = new Task("Diseñar IA", "Diseñar la arquitectura de IA", "Jane Doe", "Pendiente", LocalDate.now().plusDays(10));
        observer = mock(Observer.class);
        projectManager.addObserver(observer);
    }

    @Test
    public void testAddTask() {
        projectManager.addTask(task, username);
        verify(observer, times(1)).update("added", task);
    }

    @Test
    public void testUpdateTask() {
        projectManager.addTask(task, username); // Primero añadimos la tarea
        projectManager.updateTask(task, username);
        verify(observer, times(1)).update("updated", task);
    }

    @Test
    public void testRemoveTask() {
        projectManager.addTask(task, username); // Primero añadimos la tarea
        projectManager.removeTask(task, username);
        verify(observer, times(1)).update("removed", task);
    }

    @Test
    public void testAddObserver() {
        assertTrue(projectManager.getObservers().contains(observer));
    }

    @Test
    public void testRemoveObserver() {
        projectManager.removeObserver(observer);
        assertFalse(projectManager.getObservers().contains(observer));
    }
}
