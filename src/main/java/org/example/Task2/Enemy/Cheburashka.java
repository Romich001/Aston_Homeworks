package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class Cheburashka extends Enemy {

    private final int STRENGTH = 3;

    public Cheburashka(String name, int health) {
        super(name, health);
    }

    @Override
    public Enemy copy() {
        return new Cheburashka(getName(), getHealth());
    }

    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", getName());
        hero.takeDamage(STRENGTH);
    }
}
