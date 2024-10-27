package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class Pinocchio extends Enemy {

    private final int DAMAGE = 5;

    public Pinocchio(String name, int health) {
        super(name, health);

    }

    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", getName());
        hero.takeDamage(DAMAGE);

    }
}
