package org.example;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * Clase principal que inicia y controla el flujo del programa de gestión de proyectos.
 */
public class Main {
    /**
     * Método principal que inicia la ejecución del programa.
     * @param args Argumentos de la línea de comandos (no utilizado en este programa).
     */
    public static void main(String[] args) {
        // Implementación del programa
        // Crear el proyecto con seguridad básica
        Project project = new Project("Proyecto Alfa", "Este es un proyecto de prueba", LocalDate.of(2024, 7, 16), LocalDate.of(2025, 1, 16));
        ProjectManager projectManager = new ProjectManager(project);
        projectManager.addObserver(new TaskNotificationHandler());

        /**
         * Método de autenticación de usuario.
         * @param username Nombre de usuario para autenticar.
         * @param password Contraseña del usuario.
         * @return true si las credenciales son válidas, false en caso contrario.
         */

        Scanner in = new Scanner(System.in);
        System.out.println("ingrese usuario : ");
        // Simulación de autenticación básica
        String username = in.nextLine(); //admin
        System.out.println("ingrese contraseña : ");
        String password = in.nextLine(); //securePassword

        // Verificación de credenciales
        if (authenticate(username, password)) {
            System.out.println("Inicio de sesión exitoso.");

            // Crear y agregar una tarea con autorización
            Task task1 = new Task("Implementar inicio de sesión", "Desarrollar funcionalidad de inicio de sesión", "Kapu", "Abierta", LocalDate.of(2024, 7, 30));
            task1.setAssignmentStrategy(new SimpleTaskAssignmentStrategy());
            projectManager.addTask(task1, username);

            // Actualizar la tarea usando la estrategia de prioridad
            task1.setAssignmentStrategy(new PriorityTaskAssignmentStrategy());
            task1.assignTask();
            task1.setStatus("En progreso");
            projectManager.updateTask(task1, username);

            // Eliminar la tarea
            projectManager.removeTask(task1, username);

            // Crear y agregar una nueva tarea con la estrategia de asignación simple
            Task task2 = new Task("Implementar cierre de sesión", "Desarrollar funcionalidad de cierre de sesión", "Motita", "Pendiente", LocalDate.now().plusDays(5));
            task2.setAssignmentStrategy(new SimpleTaskAssignmentStrategy());
            task2.assignTask();
            projectManager.addTask(task2, username);
        } else {
            System.out.println("Error: credenciales inválidas.");
        }
    }

    // Método de autenticación básica (simulado)
    private static boolean authenticate(String username, String password) {
        // Implementación de la autenticación
        // En una implementación real, aquí se verificarían las credenciales
        return username.equals("admin") && password.equals("securePassword");
    }
}



