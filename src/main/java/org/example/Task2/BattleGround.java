package org.example.Task2;

import org.example.Task2.Enemy.Cheburashka;
import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Pinocchio;
import org.example.Task2.Enemy.WiniThePooh;
import org.example.Task2.Heroes.Archer;
import org.example.Task2.Heroes.Hero;
import org.example.Task2.Heroes.Mage;
import org.example.Task2.Heroes.Warrior;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BattleGround {

    private final int HEALTH = 10;


    private final List<Hero> heroes = List.of(
            new Mage("Gandalf", HEALTH),
            new Warrior("Artes", HEALTH),
            new Archer("Legolas", HEALTH)
    );
    private final List<Enemy> enemies = List.of(
            new Pinocchio("Pinochet", HEALTH),
            new WiniThePooh("BearTheTerrible", HEALTH),
            new Cheburashka("Ubivachka", HEALTH)
    );

    public static void main(String[] args) {
        var arena = new BattleGround();
        arena.startChampionship();

    }

    private void startChampionship() {

        heroes.forEach(hero -> enemies.forEach(enemy -> makeBattle(hero.copy(), enemy.copy())));
    }

    private void makeBattle(Hero hero, Enemy enemy) {
        String START_BATTLE = "FIGHT";
        System.out.println(START_BATTLE);
        while (true) {
            hero.attackEnemy(enemy);
            if (!enemy.isAlive()) break;
            enemy.attack(hero);
            if (!hero.isAlive()) break;
        }
        nameWinner(hero, enemy);

    }

    private void nameWinner(Hero hero, Enemy enemy) {
        String winner;
        String WINNER_ANNOUNCING = "%s is winner!!!\n";
        if (hero.isAlive()) {
            winner = hero.getNAME();
        } else {
            winner = enemy.getClass().getSimpleName();
        }
        System.out.printf(WINNER_ANNOUNCING, winner);
        System.out.println("________________________");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
