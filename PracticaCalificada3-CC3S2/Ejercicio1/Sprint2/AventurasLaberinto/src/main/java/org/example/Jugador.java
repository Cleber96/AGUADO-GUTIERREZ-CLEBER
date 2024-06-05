package org.example;

public class Jugador {
    private static final int MIN_POSICION = 0;
    private static final int MAX_POSICION = 9;

    private Posicion posicion;
    private int puntaje = 0;
    private int vida = 3;

    public void mover(Posicion nueva) {
        actualizarPosicion(nueva);
    }

    public void actualizarPosicion(Posicion nueva) {
        if (!verificarColision(nueva)) {
            setPosicion(nueva);
        }
    }

    public boolean verificarColision(Posicion nueva) {
        return nueva.getFila() < MIN_POSICION || nueva.getFila() > MAX_POSICION ||
                nueva.getColumna() < MIN_POSICION || nueva.getColumna() > MAX_POSICION;
    }

    public void recogerTesoro(Celda celda) {
        if(celda.obtenerTipo() == 'T') {
            setPuntaje(getPuntaje()+1);
            System.out.println("Felicidades, hemos conseguido un tesoro!!!");
        }
    }

    public boolean verificarTrampa(Celda celda) {
        if(celda.obtenerTipo() == 'X') {
            setVida(getVida()-1);
            return true;
        }
        return false;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        if (puntaje < 0) {
            throw new IllegalArgumentException("El puntaje no puede ser negativo.");
        }
        this.puntaje = puntaje;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            throw new IllegalArgumentException("La vida no puede ser negativa.");
        }
        this.vida = vida;
    }
}
