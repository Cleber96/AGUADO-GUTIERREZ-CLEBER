package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clima {
    private List<Sensor> sensores;

    private static Scanner in;

    public Clima() {
        sensores = new ArrayList<>();
        Alerta alertaPorUmbral = new AlertaPorUmbral();

        sensores.add(new Temperatura(0, alertaPorUmbral));
        sensores.add(new LLuvia(0, alertaPorUmbral));
        sensores.add(new Viento(0, alertaPorUmbral));
        sensores.add(new Humedad(0, alertaPorUmbral));
        sensores.add(new PresionAtmosferica(0, alertaPorUmbral));
    }

    public void alertas() {
        for (Sensor sensor : sensores) {
            if(sensor.verificarAlerta()) {
                System.out.println(sensor.getMensajeAlerta() + " - " + sensor.getAuxiliar());
            }
        }
    }

    public void menu() {
        System.out.println("***** MENÚ *****:");
        System.out.println("__ ELIJA UNA OPCIÓN __");
        for (int i = 0; i < sensores.size(); i++) {
            System.out.println((i + 1) + ". " + sensores.get(i).getClass().getSimpleName());
        }
        System.out.print("OPCION ELEGIDA: ");
        int opcion = in.nextInt();
        opcionElegida(opcion);
    }

    public void opcionElegida(int opcion) {
        if(opcion < 1 || opcion > sensores.size()) {
            System.out.println("Opción no válida");
            return;
        }
        System.out.print("MEDIDA REGISTRADA: ");
        double medida = in.nextDouble();
        sensores.get(opcion - 1).setValor(medida);
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        Clima clima = new Clima();
        clima.menu();
        clima.alertas();
        in.close();
    }
}
