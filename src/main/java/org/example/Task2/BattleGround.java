package org.example.Task2;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Pinocchio;
import org.example.Task2.Heroes.Warrior;

public class BattleGround {

    private static final Warrior hero = new Warrior("Gorka", 15);
    private static final Enemy villain = new Pinocchio("Pinochet", 15);
    private static String winner;

    public static void main(String[] args) {

        while (true) {
            hero.attackEnemy(villain);
            if (!villain.isAlive()) break;
            villain.attack(hero);
            if (!hero.isAlive()) break;
        }

        if (hero.isAlive()) {
            winner = hero.getNAME();
        } else {
            winner = villain.getClass().getSimpleName();
        }
        System.out.printf("%s is winner!!!\n", winner);
    }
}
