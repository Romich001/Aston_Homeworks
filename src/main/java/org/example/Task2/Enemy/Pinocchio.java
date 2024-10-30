package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class Pinocchio extends Enemy {

    private final int STRENGTH = 5;

    public Pinocchio(String name, int health) {
        super(name, health);

    }

    @Override
    public Enemy copy() {
        return new Pinocchio(getName(), getHealth());
    }


    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", getName());
        hero.takeDamage(STRENGTH);

    }
}
