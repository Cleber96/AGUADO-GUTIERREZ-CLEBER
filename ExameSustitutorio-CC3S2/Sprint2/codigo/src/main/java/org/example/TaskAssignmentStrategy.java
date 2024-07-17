package org.example;

/**
 * Interfaz para estrategias de asignación de tareas.
 */
public interface TaskAssignmentStrategy {
    /**
     * Método para asignar una tarea según la estrategia específica implementada.
     * @param task Tarea a asignar.
     */
    void assignTask(Task task);
}
