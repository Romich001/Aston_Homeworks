package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Mortal;

public abstract class Hero implements Mortal {


    private final String NAME;
    private int health;

    public Hero(String name, int health) {
        this.NAME = name;
        this.health = health;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    abstract void attackEnemy(Enemy enemy);

    public int getHealth() {
        return health;
    }
}
