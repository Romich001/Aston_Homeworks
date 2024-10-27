package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;

public class Archer extends Hero {

    private final int STRENGTH = 5;

    public Archer(String name, int health) {

        super(name, health);

    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.printf("Archer %s is attacking!\n", getNAME());
        enemy.takeDamage(STRENGTH);
    }

}
