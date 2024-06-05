package org.example;

public class EstadoHandler {
    public boolean verificarEstado(Laberinto laberinto, Jugador jugador) {
        for(int i = 0; i < laberinto.getTAMANO(); i++) {
            for(int j = 0; j < laberinto.getTAMANO(); j++) {
                if(laberinto.getTablero()[i][j].obtenerTipo() == 'T') {
                    return true;
                }
            }
        }
        return false;
    }

    public String verificarVicDerr(Jugador jugador) {
        if (jugador.getVida() == 0) {
            return "PERDISTE";
        }
        return "GANASTE";
    }
}
