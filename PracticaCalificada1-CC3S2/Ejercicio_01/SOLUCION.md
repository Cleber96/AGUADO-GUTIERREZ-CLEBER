  # cleber lee aguado gutiérrez
```java
//extraído del repositorio github kapumota
//https://github.com/kapumota/Actividades-CC3S2/blob/main/2024-1/Actividad3-AAA.md
public class Calculador {
    public int sumar(int numeroA, int numeroB) {
        return numeroA + numeroB;
    }
    public int restar(int numeroA, int numeroB) {
        return numeroA - numeroB;
    }
    public int multiplicacion(int numeroA, int numeroB) {
        return numeroA * numeroB;
    }
    public double division(int numeroA, int numeroB) {
        if (numeroB == 0) {
            throw new ArithmeticException("Division por cero");
        }
        return (double) numeroA / numeroB;
    }
}
```
# Respuesta
### Indicaciones
Escribir pruebas *PARA LAS DEMÁS** operaciones: Siguiendo el ejemplo dado, deben escribir pruebas unitarias para los otros métodos en la clase Calculator, asegurándose de cubrir casos de prueba variados, incluidos los casos límite como la división por cero.
```java
//estructura extraída del repositorio github kapumota
//https://github.com/kapumota/Actividades-CC3S2/blob/main/2024-1/Actividad3-AAA.md
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadorTest {
//RESTA
    //VALIDOS
    @Test
    public void testRes_PositiveNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(5, resultado, "10 - 5 deberia ser 5");
    }
    @Test
    public void testRes_NegativeNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(-5, resultado, "5 - 10 deberia ser -5");
    }
    @Test
    public void testRes_NeutralIzqNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = numeroB = 10;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(0, resultado, "10 - 10 deberia ser 0");
    }
    @Test
    public void testRes_NeutralDerNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = numeroB = 10;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(0, resultado, "10 - 10 deberia ser 0");
    }
    //INVALIDOS
    @Test
    public void testRes_FloatDifInterNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        float numeroA = numeroB = 10.10;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        if (numeroA..getClass().getSimpleName() == "int" || numeroB..getClass().getSimpleName() == "int") {
            assertEquals("invalid", resultado, "10.10 - 10.10 deberia ser invalid");
        }
    }
//RESTA
    //VALIDOS
    @Test
    public void testRes_PositiveNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(5, resultado, "10 - 5 deberia ser 5");
    }
    @Test
    public void testRes_NegativeNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(-5, resultado, "5 - 10 deberia ser -5");
    }
    @Test
    public void testRes_NeutralIzqNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = numeroB = 10;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(0, resultado, "10 - 10 deberia ser 0");
    }
    @Test
    public void testRes_NeutralDerNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = numeroB = 10;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        assertEquals(0, resultado, "10 - 10 deberia ser 0");
    }
    //INVALIDOS
    @Test
    public void testRes_FloatDifInterNumbers_ShouldReturnCorrectRes() {
        // Arrange
        Calculador calculador = new Calculador();
        float numeroA = numeroB = 10.10;
        // Act
        int resultado = calculador.resta(numeroA, numeroB);
        // Assert
        if (numeroA..getClass().getSimpleName() == "int" || numeroB..getClass().getSimpleName() == "int") {
            assertEquals("invalid", resultado, "10.10 - 10.10 deberia ser invalid");
        }
    }
}
```
