package org.example.Task2.Heroes;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attackEnemy() {
        System.out.printf("Warrior %s is attacking!\n", getName());
    }
}
