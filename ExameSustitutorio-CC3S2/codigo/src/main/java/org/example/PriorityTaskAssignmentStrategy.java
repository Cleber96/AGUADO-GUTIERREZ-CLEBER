package org.example;

public class PriorityTaskAssignmentStrategy implements TaskAssignmentStrategy {
    @Override
    public void assignTask(Task task) {
        task.setAssignedTo("Asignado por prioridad");
    }
}