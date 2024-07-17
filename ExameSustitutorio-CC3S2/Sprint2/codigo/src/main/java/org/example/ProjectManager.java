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
        // Implementación del constructor
    }

    /**
     * Añade una nueva tarea al proyecto.
     * @param task Tarea a añadir al proyecto.
     * @param username Nombre de usuario que realiza la acción.
     */
    public void addTask(Task task, String username) {
        // Implementación para añadir tarea
    }

    /**
     * Actualiza una tarea existente en el proyecto.
     * @param task Tarea a actualizar.
     * @param username Nombre de usuario que realiza la acción.
     */
    public void updateTask(Task task, String username) {
        // Implementación para actualizar tarea
    }

    /**
     * Elimina una tarea del proyecto.
     * @param task Tarea a eliminar.
     * @param username Nombre de usuario que realiza la acción.
     */
    public void removeTask(Task task, String username) {
        // Implementación para eliminar tarea
    }

    /**
     * Añade un observador para recibir notificaciones de cambios en el proyecto.
     * @param observer Observador a añadir.
     */
    @Override
    public void addObserver(Observer observer) {
        // Implementación para añadir observador
    }

    /**
     * Elimina un observador registrado.
     * @param observer Observador a eliminar.
     */
    @Override
    public void removeObserver(Observer observer) {
        // Implementación para eliminar observador
    }

    /**
     * Notifica a todos los observadores sobre un cambio en el proyecto.
     * @param changeType Tipo de cambio realizado (añadido, actualizado, eliminado, etc.).
     * @param task Tarea afectada por el cambio.
     */
    @Override
    public void notifyObservers(String changeType, Task task) {
        // Implementación para notificar a observadores
    }

    /**
     * Verifica si el usuario tiene permisos para realizar una acción.
     * @param username Nombre de usuario para verificar permisos.
     * @return true si el usuario tiene permisos, false en caso contrario.
     */
    public boolean authorize(String username) {
        // Implementación para autorización de usuario
        return false;
    }

    /**
     * Encripta los datos sensibles para proteger la información.
     * @param data Datos sensibles que serán encriptados.
     */
    public void encryptData(String data) {
        // Implementación para encriptación de datos
    }

    // Getters y setters omitidos para brevedad
}
