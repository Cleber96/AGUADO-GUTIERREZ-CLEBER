package org.example;

/**
 * Interfaz para objetos observables que pueden tener observadores registrados.
 */
public interface Observable {
    /**
     * Añade un observador al objeto observable.
     * @param observer Observador a añadir.
     */
    void addObserver(Observer observer);

    /**
     * Elimina un observador del objeto observable.
     * @param observer Observador a eliminar.
     */
    void removeObserver(Observer observer);

    /**
     * Notifica a todos los observadores registrados sobre un cambio en el objeto observable.
     * @param changeType Tipo de cambio realizado.
     * @param task Objeto relacionado con el cambio.
     */
    void notifyObservers(String changeType, Task task);
}
