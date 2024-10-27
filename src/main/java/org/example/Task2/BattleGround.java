package org.example.Task2;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Heroes.Hero;
import org.example.Task2.Heroes.Warrior;

public class BattleGround {

    private static final Warrior gorka = new Warrior("Gorka", 15);
    private static final Enemy artes = new Enemy(15);
    private static String winner;

    public static void main(String[] args) {

        do {
            gorka.attackEnemy(artes);
            artes.attack(gorka);
        } while (gorka.isAlive() && artes.isAlive());

        if (gorka.isAlive()) {
            winner = gorka.getNAME();
        } else {
            winner = artes.getClass().getSimpleName();
        }
        System.out.printf("%s is winner!!!\n", winner);
    }
}
