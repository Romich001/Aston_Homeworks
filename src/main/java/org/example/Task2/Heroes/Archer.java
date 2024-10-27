package org.example.Task2.Heroes;

public class Archer extends Hero {
    public Archer(String name) {
        super(name);
    }

    @Override
    public void attackEnemy() {
        System.out.printf("Archer %s is attacking!\n", getName());
    }
}
