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
- OCP: La clase Celda está cerrada para la modificación pero abierta para la extensión. por ejemplo la extendemos
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
- SRP: la clase Jugador tiene muchas responsabilidades `mover` `verificarColision` `recogerTesoro` `verificarTrampa` además de los getters y setters, por lo que se debería preferir dividirlo usando interface.
```java
public interface Movible {
    void mover(Posicion nueva);
    void actualizarPosicion(Posicion nueva);
}

public interface Recolector {
    void recogerTesoro(Celda celda);
    boolean verificarTrampa(Celda celda);
}
```
- OCP: con la `interface` también lograremos que sea cerrada para modificaciones, pero abierta para extensiones creando nuevas, de esta manera no modificar el código existente.
- LSP: no tiene subtipos directos
- ISP: ya dividimos sus responsabilidades en interfaces
- DIP: solo depende de la clase `Posicion` y `Celda`, pero se modificarán de clases a interfaces porque esas clases son parte central del proyecto
### clase Laberinto:
- SRP: Extraer la lógica relacionada con la creación y manipulación del laberinto para separar las responsabilidades.
```java
public interface LaberintoGenerator {
    void llenarTableroConElementos();
    char colocarTesoroTrampa();
    Posicion colocarJugadorEnTablero();
}

```
- OCP: Hacer que la lógica de colocación de elementos en el tablero sea más flexible, permitiendo que diferentes tipos de elementos se coloquen en el tablero de diferentes maneras. Esto podría lograrse a través de una interfaz ElementoGenerador y clases concretas que implementen esta interfaz para cada tipo de elemento.
- LSP: No hay subclases directas de Laberinto, por lo que no hay violación directa del LSP.
- ISP: Podemos dividir la clase Laberinto en clases más pequeñas y cohesivas, si es necesario, para evitar que las clases que la implementan tengan que proporcionar funcionalidades que no necesitan.
```java
public class LaberintoGenerico implements LaberintoGenerator{
    int TAMANO;
    Celda[][] tablero;
    Random rand;
    public LaberintoGenerico(Celda[][] tablero, int TAMANO) {
        this.TAMANO = TAMANO;
        this.tablero = tablero;
        rand = new Random();
    }
    @Override
    public void llenarTableroConElementos() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = new Celda(colocarTesoroTrampa());
            }
        }
    }
    @Override
    public char colocarTesoroTrampa() {
        switch (rand.nextInt(3)) {
            case 0: return '.';
            case 1: return 'T';
            case 2: return 'X';
            default: throw new IllegalStateException("Valor aleatorio fuera de rango");
        }
    }
    @Override
    public Posicion colocarJugadorEnTablero() {
        int fila = rand.nextInt(TAMANO);
        int columna = rand.nextInt(TAMANO);
        tablero[fila][columna] = new Celda('P');
        return new Posicion(fila, columna);
    }
}
public class Laberinto implements Tablero{
    //atributos obviados
    public Posicion iniciar() {
        this.tablero = new Celda[TAMANO][TAMANO];
        laberintoGenerico = new LaberintoGenerico(tablero, TAMANO);
        laberintoGenerico.llenarTableroConElementos();
        return laberintoGenerico.colocarJugadorEnTablero();
    }
    //demás métodos
}
```
- DIP:  podemos introducir una abstracción como Tablero para desacoplar la clase.
```java
public interface Tablero {
    void mostrar();
    void actualizarCelda(int fila, int columna, char nuevoTipo);
}
```
### clase Juego:
- SRP:  Separé la lógica del juego, el manejo de movimientos y la verificación del estado en clases diferentes (Juego, MovimientoHandler, EstadoHandler)
```java
public class MovimientoHandler {
    public void mover(char direccion, Jugador jugador, Laberinto laberinto) {
        Posicion nuevaPosicion = calcularNuevaPosicion(direccion, jugador.getPosicion());
        if (!jugador.verificarColision(nuevaPosicion)) {
            Celda nuevaCelda = laberinto.getTablero()[nuevaPosicion.getFila()][nuevaPosicion.getColumna()];
            if(jugador.verificarTrampa(nuevaCelda)) {
                System.out.println("Ten cuidado ¡trampa! Pierdes una vida");
            }
            jugador.recogerTesoro(nuevaCelda);
            laberinto.actualizarCelda(jugador.getPosicion().getFila(), jugador.getPosicion().getColumna(), '.');
            laberinto.actualizarCelda(nuevaPosicion.getFila(), nuevaPosicion.getColumna(),'P');
            jugador.mover(nuevaPosicion);
        }
    }

    private Posicion calcularNuevaPosicion(char direccion, Posicion posicionActual) {
        int fila = posicionActual.getFila();
        int columna = posicionActual.getColumna();
        switch (direccion) {
            case 'N': return new Posicion(fila - 1, columna);
            case 'S': return new Posicion(fila + 1, columna);
            case 'E': return new Posicion(fila, columna + 1);
            case 'O': return new Posicion(fila, columna - 1);
            default: return new Posicion(-1, -1);
        }
    }
}

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

```
- OCP: La clase Juego es fácilmente extensible, pudiendo agregar nuevas funcionalidades sin modificar las clases existentes.
- LSP: Las nuevas clases derivadas pueden ser utilizadas sin problemas en lugar de las clases base.
- ISP: No tenemos interfaces innecesariamente grandes, pero las responsabilidades están bien segregadas.
- DIP: `Juego` depende de abstracciones (Laberinto, Jugador, MovimientoHandler, EstadoHandler) en lugar de implementaciones concretas, lo que hace que el código sea más flexible y fácil de mantener.
```java
import java.util.Scanner;

public class Juego {
    private final Laberinto laberinto;
    private final Jugador jugador;
    private final MovimientoHandler movimientoHandler;
    private final EstadoHandler estadoHandler;

    public Juego(Laberinto laberinto, Jugador jugador, MovimientoHandler movimientoHandler, EstadoHandler estadoHandler) {
        this.laberinto = laberinto;
        this.jugador = jugador;
        this.movimientoHandler = movimientoHandler;
        this.estadoHandler = estadoHandler;
    }

    public void iniciar() {
        Posicion posicionJugador = laberinto.iniciar();
        jugador.setPosicion(posicionJugador);
    }

    public void procesarComando(char direccion) {
        movimientoHandler.mover(direccion, jugador, laberinto);
    }

    public boolean actulizarEstado() {
        boolean estado = estadoHandler.verificarEstado(laberinto, jugador);
        if (!estado) {
            System.out.println(estadoHandler.verificarVicDerr(jugador));
        }
        return estado;
    }

    public static void main(String[] args) {
        Laberinto laberinto = new Laberinto(new LaberintoGeneratorNormal());
        Jugador jugador = new Jugador();
        MovimientoHandler movimientoHandler = new MovimientoHandler();
        EstadoHandler estadoHandler = new EstadoHandler();

        Juego juego = new Juego(laberinto, jugador, movimientoHandler, estadoHandler);
        juego.iniciar();
        juego.laberinto.mostrar();
        Scanner in = new Scanner(System.in);
        while (juego.actulizarEstado()) {
            System.out.println("MENÚ\n - N: Norte\n - S: Sur\n - E: Este\n - O: Oeste");
            System.out.print("Ingrese movimiento (letra): ");
            char direccion = in.next().charAt(0);
            juego.procesarComando(direccion);
            System.out.println("\tPUNTAJE ACTUAL : (" + juego.jugador.getPuntaje() + ")");
            System.out.println("\tVIDA ACTUAL : (" + juego.jugador.getVida() + ")");
            System.out.println("\tPOSICION ACTUAL : (" + juego.jugador.getPosicion().getFila() + "," + juego.jugador.getPosicion().getColumna() + ")\n");
            juego.laberinto.mostrar();
        }
        in.close();
    }
}
```

• Implementar inyección de dependencias.
# Métricas de Calidad:
• Calcular LCOM, LCOM4, CAMC y complejidad ciclomática.
• Mejorar cohesión y reducir complejidad según las métricas obtenidas.
Salidas:
• Reporte de métri- SRP: cada método tien una sola responsabilidad: constructor y otro método que cumple la función de getter.

