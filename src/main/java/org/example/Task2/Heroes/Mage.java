package org.example.Task2.Heroes;

public class Mage extends Hero {
    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemy() {
        System.out.printf("Mage %s is attacking!\n", getName());
    }
}
