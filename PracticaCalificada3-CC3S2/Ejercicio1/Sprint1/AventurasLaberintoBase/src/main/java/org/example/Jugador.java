package org.example;

public class Jugador {
    private Posicion posicion;
    private int puntaje = 0;
    private int vida = 3;

    public void mover(Posicion nueva) {
        //funcionalidad
    }

    public void actualizarPosicion(Posicion nueva) {
        //funcionalidad
    }

    public boolean verificarColision(Posicion nueva) {
        return false;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
