package org.example;

public class SimpleTaskAssignmentStrategy implements TaskAssignmentStrategy {
    @Override
    public void assignTask(Task task) {
        // Lógica de asignación simple
        task.setAssignedTo("Asignado automáticamente");
    }
}