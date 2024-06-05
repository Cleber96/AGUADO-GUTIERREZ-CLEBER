# Refactorización: SOLID
### clase Celda: 
- es evidente que al ser una clase sencilla no hace falta refactorizar nada
```java
public class Celda {
    private char tipo;
    public Celda(char tipo) {
        this.tipo = tipo;
    }
    public char obtenerTipo() {
        return tipo;
    }
}
```
- SRP: cada método tien una sola responsabilidad: constructor y otro método que cumple la función de getter.
- OCP: La clase Celda está cerrada para la modificación pero abierta para la extensión. por ejemplo
```java
public class CeldaTesoro extends Celda {
    public CeldaTesoro() {
        super('T');
    }
}
```
- LSP: `CeldaTesoro` puede sustituir a Celda sin alterar el correcto funcionamiento del programa, pero deberíamos implementar sus demás variantes
- ISP: no necesita cambios específicos para este principio, ya que es simple y directa.
- DIP: es una clase concreta y no depende de abstracciones.

### clase Jugador: 
```java
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
    //en los setters ya se implementa excepciones, pero solo dejo uno para la presentación. los demás se encuentran en el código fuente Sprint3/AventuraLaberinto.ideaProyect
    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }
}
```
### clase Laberinto:
### clase Juego:


• Implementar inyección de dependencias.
# Métricas de Calidad:
• Calcular LCOM, LCOM4, CAMC y complejidad ciclomática.
• Mejorar cohesión y reducir complejidad según las métricas obtenidas.
Salidas:
• Reporte de métricas de calidad antes y después de la refactorización.
• Código refactorizado con pruebas unitarias exitosas.