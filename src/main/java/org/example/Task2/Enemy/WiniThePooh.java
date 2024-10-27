package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class WiniThePooh extends Enemy {

    private final int DAMAGE = 7;

    public WiniThePooh(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", this.getClass().getSimpleName());
        hero.takeDamage(DAMAGE);
    }
}
