package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;

public class Mage extends Hero {

    private final int STRENGTH = 3;

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.printf("Mage %s is attacking!\n", getNAME());
        enemy.takeDamage(STRENGTH);
    }
}
