package org.example.Task2;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Heroes.Warrior;

public class BattleGround {
    public static void main(String[] args) {
        var gorka = new Warrior("Gorka", 15);
        var artes = new Enemy(15);
        do {
            gorka.attackEnemy(artes);

        } while (artes.isAlive());

    }
}
