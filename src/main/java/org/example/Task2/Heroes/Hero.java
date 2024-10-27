package org.example.Task2.Heroes;

public class Hero {
    private final String name;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attackEnemy() {
        System.out.println("Hero is attacking!");
    }

}
