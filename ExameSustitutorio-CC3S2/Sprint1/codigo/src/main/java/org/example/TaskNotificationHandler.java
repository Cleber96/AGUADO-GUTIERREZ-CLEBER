package org.example;

public class TaskNotificationHandler implements Observer {
    @Override
    public void update(String changeType, Task task) {
        switch (changeType) {
            case "added":
                System.out.println("Nueva tarea añadida: " + task.getTitle());
                break;
            case "updated":
                System.out.println("Tarea actualizada: " + task.getTitle());
                break;
            case "removed":
                System.out.println("Tarea eliminada: " + task.getTitle());
                break;
            default:
                System.out.println("Tipo de cambio desconocido");
        }
    }
}

