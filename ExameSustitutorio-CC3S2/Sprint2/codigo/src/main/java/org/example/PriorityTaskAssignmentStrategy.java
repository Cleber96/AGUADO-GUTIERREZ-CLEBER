package org.example;

/**
 * Implementación de TaskAssignmentStrategy que asigna la tarea basada en prioridad.
 */
public class PriorityTaskAssignmentStrategy implements TaskAssignmentStrategy {
    /**
     * Asigna la tarea con prioridad específica.
     * @param task Tarea a asignar por prioridad.
     */
    @Override
    public void assignTask(Task task) {
        task.setAssignedTo("Asignado por prioridad");
    }
}
