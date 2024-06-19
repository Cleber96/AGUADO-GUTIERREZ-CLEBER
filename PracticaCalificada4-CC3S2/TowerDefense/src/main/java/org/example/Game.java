package org.example;

import java.util.Scanner;

public class Game {
    private final static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("PLACE_TOWER Cannon ");
        int raw = in.nextInt();
        int column = in.nextInt();
        System.out.print("START_WAVE...\n");
        System.out.println("Torre Cannon colocada en (" + raw +", " + column +")");
        int nOleada = 1;
        Map map = new Map();
        Player player = new Player();
        while(player.getLife() > 0 && nOleada == 1) {    //condición oleada==1 para no bucle
            System.out.println("Oleada " + nOleada + " iniciada");
            System.out.println("Enemigos en camino...");
            System.out.println("Estado del juego:");
            map.printMap();
            System.out.println("Puntuación: " + player.getScore());
            System.out.println("Vida de la base: " + player.getLife());
            System.out.println();
            nOleada++;
        }
        System.out.println("GAME OVER");
    }
}
