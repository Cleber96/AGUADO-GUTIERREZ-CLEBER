package org.example;

/**
 * Manejador de notificaciones de tareas que implementa la interfaz Observer.
 */
public class TaskNotificationHandler implements Observer {
    /**
     * Método que maneja la actualización de una tarea.
     * @param changeType Tipo de cambio realizado (añadido, actualizado, eliminado, etc.).
     * @param task Tarea afectada por el cambio.
     */
    @Override
    public void update(String changeType, Task task) {
        // Implementación para manejar actualización de tarea
    }
}

