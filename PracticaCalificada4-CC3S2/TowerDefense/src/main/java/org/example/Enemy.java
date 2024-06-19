package org.example;

import java.util.List;

public abstract class Enemy {
    protected int speed;
    protected int health;
    protected int reward;

    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }

    public void move() {

    }
}
