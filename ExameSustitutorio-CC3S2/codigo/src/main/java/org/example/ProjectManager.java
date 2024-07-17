package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Gestor de proyectos que administra las tareas y notifica a los observadores sobre cambios.
 */
public class ProjectManager implements Observable {
    private Project project;
    private List<Task> tasks;
    private List<Observer> observers;


    /**
     * Constructor para inicializar el gestor de proyectos con un proyecto específico.
     * @param project Proyecto que será gestionado por este gestor.
     */
    public ProjectManager(Project project) {
        this.project = project;
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
    /**
     * Añade una nueva tarea al proyecto.
     * @param task Tarea a añadir al proyecto.
     * @param username Nombre de usuario que realiza la acción.
     */
    // Métodos para añadir, actualizar y eliminar tareas
    public void addTask(Task task, String username) {
        // Verificar autorización antes de agregar la tarea
        if (authorize(username)) {
            tasks.add(task);
            notifyObservers("added", task);
        } else {
            System.out.println("No tienes permisos para agregar tareas.");
        }
    }
    /**
     * Actualiza una tarea existente en el proyecto.
     * @param task Tarea a actualizar.
     * @param username Nombre de usuario que realiza la acción.
     */
    public void updateTask(Task task, String username) {
        // Verificar autorización antes de actualizar la tarea
        if (authorize(username)) {
            // Lógica para actualizar una tarea
            notifyObservers("updated", task);
        } else {
            System.out.println("No tienes permisos para actualizar tareas.");
        }
    }
    /**
     * Elimina una tarea del proyecto.
     * @param task Tarea a eliminar.
     * @param username Nombre de usuario que realiza la acción.
     */
    public void removeTask(Task task, String username) {
        // Verificar autorización antes de eliminar la tarea
        if (authorize(username)) {
            tasks.remove(task);
            notifyObservers("removed", task);
        } else {
            System.out.println("No tienes permisos para eliminar tareas.");
        }
    }
    /**
     * Verifica si el usuario tiene permisos para realizar una acción.
     * @param username Nombre de usuario para verificar permisos.
     * @return true si el usuario tiene permisos, false en caso contrario.
     */
    // Métodos de seguridad adicionales
    public boolean authorize(String username) {
        // Implementación básica de autorización
        // En una implementación real, validarías roles y permisos específicos
        return username.equals("admin");
    }
    /**
     * Encripta los datos sensibles para proteger la información.
     * @param data Datos sensibles que serán encriptados.
     */
    public void encryptData(String data) {
        // Implementación básica de encriptación
        // Aquí iría la lógica para encriptar los datos sensibles
        System.out.println("Datos encriptados: " + data);
    }
    /**
     * Añade un observador para recibir notificaciones de cambios en el proyecto.
     * @param observer Observador a añadir.
     */
    // Métodos para observadores y gestión de tareas
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    /**
     * Elimina un observador registrado.
     * @param observer Observador a eliminar.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    /**
     * Notifica a todos los observadores sobre un cambio en el proyecto.
     * @param changeType Tipo de cambio realizado (añadido, actualizado, eliminado, etc.).
     * @param task Tarea afectada por el cambio.
     */
    @Override
    public void notifyObservers(String changeType, Task task) {
        for (Observer observer : observers) {
            observer.update(changeType, task);
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
}

