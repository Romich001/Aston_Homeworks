package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;

public abstract class Hero {
    private final String NAME;
    private final int STRENGTH = 2;

    public Hero(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    abstract void attackEnemy(Enemy enemy);

}
