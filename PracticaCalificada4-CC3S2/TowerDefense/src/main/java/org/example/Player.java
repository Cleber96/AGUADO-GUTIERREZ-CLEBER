package org.example;

public class Player {
    private int score;
    private int life;
    public Player() {
        this.score = 0;
        this.life = 100;
    }
    public void addScore(int points) {
        this.score += points;
    }
    public void deductLife(int damage) {
        this.life -= damage;
    }
    public int getScore() {
        return score;
    }
    public int getLife() {
        return life;
    }

}