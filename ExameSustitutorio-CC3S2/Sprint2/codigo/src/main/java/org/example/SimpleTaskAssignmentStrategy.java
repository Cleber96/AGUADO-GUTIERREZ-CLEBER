package org.example;

/**
 * Implementación de TaskAssignmentStrategy que asigna automáticamente la tarea.
 */
public class SimpleTaskAssignmentStrategy implements TaskAssignmentStrategy {
    /**
     * Asigna automáticamente la tarea especificada.
     * @param task Tarea a asignar automáticamente.
     */
    @Override
    public void assignTask(Task task) {
        task.setAssignedTo("Asignado automáticamente");
    }
}
