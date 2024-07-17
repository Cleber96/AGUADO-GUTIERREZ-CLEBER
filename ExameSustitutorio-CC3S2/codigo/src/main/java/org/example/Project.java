package org.example;

import java.time.LocalDate;

public class Project {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    /**
     * Constructor para inicializar un proyecto con nombre, descripción, fecha de inicio y fecha de finalización.
     * @param name Nombre del proyecto.
     * @param description Descripción del proyecto.
     * @param startDate Fecha de inicio del proyecto.
     * @param endDate Fecha de finalización del proyecto.
     */
    public Project(String name, String description, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters y setters para cada atributo
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
