package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class Pinocchio extends Enemy {

    private final int DAMAGE = 5;

    public Pinocchio(int health) {
        super(health);
    }

    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", this.getClass().getSimpleName());
        hero.takeDamage(DAMAGE);

    }
}
