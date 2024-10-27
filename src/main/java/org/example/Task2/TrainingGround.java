package org.example.Task2;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Heroes.Archer;
import org.example.Task2.Heroes.Mage;
import org.example.Task2.Heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {
        var warrior = new Warrior("Gorka");
        var mage = new Mage("Gendalf");
        var archer = new Archer("Legolas");
        var enemy = new Enemy(10);
        System.out.println(enemy.getHealth());
        warrior.attackEnemy(enemy);
        System.out.println(enemy.getHealth());
        mage.attackEnemy(enemy);
        System.out.println(enemy.getHealth());
        archer.attackEnemy(enemy);
        System.out.println(enemy.getHealth());

    }
}
