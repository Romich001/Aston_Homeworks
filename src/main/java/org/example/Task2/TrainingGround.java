package org.example.Task2;

import org.example.Task2.Heroes.Archer;
import org.example.Task2.Heroes.Hero;
import org.example.Task2.Heroes.Mage;
import org.example.Task2.Heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {
        var hero = new Hero("Roma");
        var warrior = new Warrior("Gorka");
        var mage = new Mage("Gendalf");
        var archer = new Archer("Legolas");
        hero.attackEnemy();
        warrior.attackEnemy();
        mage.attackEnemy();
        archer.attackEnemy();

    }
}
