package org.example.Task2.Enemy;

import org.example.Task2.Heroes.Hero;

public class WiniThePooh extends Enemy {

    private final int STRENGTH = 7;

    public WiniThePooh(String name, int health) {
        super(name, health);
    }

    @Override
    public Enemy copy() {
        return new WiniThePooh(getName(), getHealth());
    }

    @Override
    public void attack(Hero hero) {
        System.out.printf("%s is attacking.\n", this.getClass().getSimpleName());
        hero.takeDamage(STRENGTH);
    }
}
