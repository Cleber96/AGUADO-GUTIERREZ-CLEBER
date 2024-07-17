package org.example;

public interface Observer {
    void update(String changeType, Task task);
}