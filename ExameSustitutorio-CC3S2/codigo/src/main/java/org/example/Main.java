package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Project project = new Project("Desarrollo de IA", "Desarrollando módulos de IA", LocalDate.now(), LocalDate.now().plusMonths(3));
        ProjectManager projectManager = new ProjectManager(project);
        projectManager.addObserver(new TaskNotificationHandler());

        Task task1 = new Task("Diseñar IA", "Diseñar la arquitectura de IA", "Jane Doe", "Pendiente", LocalDate.now().plusDays(10));

        // Asignar estrategia de asignación simple
        task1.setAssignmentStrategy(new SimpleTaskAssignmentStrategy());
        task1.assignTask();
        projectManager.addTask(task1);

        // Cambiar estrategia y asignar tarea
        task1.setAssignmentStrategy(new PriorityTaskAssignmentStrategy());
        task1.assignTask();
        projectManager.updateTask(task1);

        projectManager.removeTask(task1);
    }
}