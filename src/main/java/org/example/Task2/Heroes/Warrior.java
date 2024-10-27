package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;

public class Warrior extends Hero {

    private final int STRENGTH = 7;

    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.printf("Warrior %s is attacking!\n", getNAME());
        enemy.takeDamage(STRENGTH);
    }

}
