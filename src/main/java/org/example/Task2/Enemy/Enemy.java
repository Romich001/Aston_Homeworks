package org.example.Task2.Enemy;

import org.example.Task2.Interfaces.Mortal;
import org.example.Task2.Heroes.Hero;

public abstract class Enemy implements Mortal {

    private final String name;  //evil don't have name.!!!!
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract Enemy copy();

    public abstract void attack(Hero hero);

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.printf("%s health is %d\n", this.getClass().getSimpleName(), health);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}
