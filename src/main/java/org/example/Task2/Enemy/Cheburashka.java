package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class Cheburashka extends Enemy {

    private final int DAMAGE = 3;

    public Cheburashka(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", getName());
        hero.takeDamage(DAMAGE);
    }
}
