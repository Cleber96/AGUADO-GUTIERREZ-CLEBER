package org.example;

/**
 * Interfaz para objetos que actúan como observadores de objetos observables.
 */
public interface Observer {
    /**
     * Método que se llama cuando un objeto observable notifica a este observador sobre un cambio.
     * @param changeType Tipo de cambio realizado.
     * @param task Objeto relacionado con el cambio.
     */
    void update(String changeType, Task task);
}
