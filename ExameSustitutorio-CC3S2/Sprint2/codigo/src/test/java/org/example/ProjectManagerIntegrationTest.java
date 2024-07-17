package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ProjectManagerIntegrationTest {

    private ProjectManager projectManager;
    private Observer mockObserver;

    @BeforeEach
    public void setup() {
        // Inicialización del ProjectManager con un proyecto de prueba
        Project project = new Project("Proyecto de Prueba", "Descripción de prueba", LocalDate.now(), LocalDate.now().plusMonths(3));
        projectManager = new ProjectManager(project);

        // Mock del Observer para simular notificaciones
        mockObserver = mock(Observer.class);
        projectManager.addObserver(mockObserver);
    }

    @Test
    public void testAddTask() {
        // Crear una tarea de prueba
        Task task = new Task("Tarea de Prueba", "Descripción de la tarea de prueba", "Usuario Prueba", "Pendiente", LocalDate.now().plusDays(10));

        // Ejecutar el método bajo prueba
        projectManager.addTask(task);

        // Verificar que se notifique al Observer correctamente
        ArgumentCaptor<String> changeTypeCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(mockObserver, times(1)).update(changeTypeCaptor.capture(), taskCaptor.capture());

        assertEquals("added", changeTypeCaptor.getValue());
        assertEquals("Tarea de Prueba", taskCaptor.getValue().getTitle());
    }

    @Test
    public void testRemoveTask() {
        // Crear una tarea de prueba
        Task task = new Task("Tarea de Prueba", "Descripción de la tarea de prueba", "Usuario Prueba", "Pendiente", LocalDate.now().plusDays(10));
        projectManager.addTask(task);

        // Ejecutar el método bajo prueba
        projectManager.removeTask(task);

        // Verificar que se notifique al Observer correctamente
        ArgumentCaptor<String> changeTypeCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(mockObserver, times(1)).update(changeTypeCaptor.capture(), taskCaptor.capture());

        assertEquals("removed", changeTypeCaptor.getValue());
        assertEquals("Tarea de Prueba", taskCaptor.getValue().getTitle());
    }

    @Test
    public void testUpdateTask() {
        // Crear una tarea de prueba
        Task task = new Task("Tarea de Prueba", "Descripción de la tarea de prueba", "Usuario Prueba", "Pendiente", LocalDate.now().plusDays(10));
        projectManager.addTask(task);

        // Cambiar el estado de la tarea
        task.setStatus("En Progreso");

        // Ejecutar el método bajo prueba
        projectManager.updateTask(task);

        // Verificar que se notifique al Observer correctamente
        ArgumentCaptor<String> changeTypeCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(mockObserver, times(1)).update(changeTypeCaptor.capture(), taskCaptor.capture());

        assertEquals("updated", changeTypeCaptor.getValue());
        assertEquals("Tarea de Prueba", taskCaptor.getValue().getTitle());
        assertEquals("En Progreso", taskCaptor.getValue().getStatus());
    }
}
