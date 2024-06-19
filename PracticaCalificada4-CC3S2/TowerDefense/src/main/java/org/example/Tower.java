package org.example;

import java.util.List;

public abstract class Tower {
    protected int damage;
    protected int range;
    protected int fireRate;
    protected int posX, posY;

    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
    }

    public void setPosition(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public abstract void attack(List<Enemy> enemies);
}