package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager implements Observable {
    private Project project;
    private List<Task> tasks;
    private List<Observer> observers;

    public ProjectManager(Project project) {
        this.project = project;
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers("added", task);
    }

    public void updateTask(Task task) {
        // Lógica para actualizar una tarea
        notifyObservers("updated", task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        notifyObservers("removed", task);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String changeType, Task task) {
        for (Observer observer : observers) {
            observer.update(changeType, task);
        }
    }
}

