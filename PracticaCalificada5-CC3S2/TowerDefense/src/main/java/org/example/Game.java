package org.example;

import org.example.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int nOleada = 1;
        Map map = new Map();
        Player player = new Player();
        List<Wave> wave = new ArrayList<>();
        while(player.getBaseHealth() > 0 && nOleada == 1) {    //condición oleada==1 para no bucle
            System.out.println("______ENTRADA:______");
            System.out.print("PLACE_TOWER Cannon ");
            int raw = in.nextInt();
            int column = in.nextInt();
            map.placeTower(raw-1,column-1);
            System.out.print("START_WAVE...\n");
            System.out.println("______SALIDA:______");
            System.out.println("Torre Cannon colocada en (" + raw +", " + column +")");
            wave.add(new Wave(nOleada));
            System.out.println("Oleada " + nOleada + " iniciada");
            System.out.println("Enemigos en camino...");
            map.addEnemies(wave.get(nOleada - 1).getEnemies());
            //atacar y defenderse
            System.out.println("Estado del juego:");
            map.printMap();
            System.out.println("Puntuación: " + player.getScore());
            System.out.println("Vida de la base: " + player.getBaseHealth());
            System.out.println();
            nOleada++;
        }
        System.out.println("GAME OVER");
    }
}
