package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Interfaces.Mortal;

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

    //checks if a person is alive
    @Override
    public boolean isAlive() {
        return health > 0;
    }

    //subtract damage from health
    public void takeDamage(int damage) {
        health -= damage;
        System.out.printf("%s health is %d\n", this.getClass().getSimpleName(), health);
    }

    public abstract void attackEnemy(Enemy enemy);

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
