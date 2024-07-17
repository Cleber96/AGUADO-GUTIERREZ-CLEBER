package org.example;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private String assignedTo;
    private String status;
    private LocalDate dueDate;

    public Task(String title, String description, String assignedTo, String status, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
        this.dueDate = dueDate;
    }

    private TaskAssignmentStrategy assignmentStrategy;
    public void assignTask() {
        if (assignmentStrategy != null) {
            assignmentStrategy.assignTask(this);
        } else {
            throw new IllegalStateException("No se ha especificado una estrategia de asignación");
        }
    }

    public void setAssignmentStrategy(TaskAssignmentStrategy assignmentStrategy) {
        this.assignmentStrategy = assignmentStrategy;
    }

    // Getters y setters para cada atributo
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}


