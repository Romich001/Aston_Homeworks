package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;

public class Hero {
    private final String NAME;
    private final int STRENGTH = 2;

    public Hero(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    public void attackEnemy(Enemy enemy) {
        System.out.println("Hero is attacking!");
        enemy.takeDamage(STRENGTH);
    }

}
