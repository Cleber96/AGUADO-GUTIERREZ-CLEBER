package org.example;

public class TaskNotificationHandler implements Observer {
    /**
     * Método que maneja la actualización de una tarea.
     * @param changeType Tipo de cambio realizado (añadido, actualizado, eliminado, etc.).
     * @param task Tarea afectada por el cambio.
     */
    @Override
    public void update(String changeType, Task task) {
        switch (changeType) {
            case "added":
                System.out.println("Tarea agregada: " + task.getTitle());
                System.out.println("Descripción: " + task.getDescription());
                System.out.println("Asignada a: " + task.getAssignedTo());
                System.out.println("Estado: " + task.getStatus());
                System.out.println("Fecha de vencimiento: " + task.getDueDate());
                break;
            case "updated":
                System.out.println("Tarea actualizada: " + task.getTitle());
                System.out.println("Nuevo estado: " + task.getStatus());
                break;
            case "removed":
                System.out.println("Tarea eliminada: " + task.getTitle());
                break;
            default:
                System.out.println("Tipo de cambio desconocido");
        }
    }
}


