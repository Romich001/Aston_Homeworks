package org.example.Task2.Enemy;

import org.example.Interfaces.Mortal;
import org.example.Task2.Heroes.Hero;

public class Enemy implements Mortal {
    private int health;
    private final int DAMAGE = 4;

    public Enemy(int health) {
        this.health = health;
    }

    public void attack(Hero hero) {
        System.out.println("Enemy is attacking!");
        hero.takeDamage(DAMAGE);
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
