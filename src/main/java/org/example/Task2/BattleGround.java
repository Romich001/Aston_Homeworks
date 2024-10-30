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

    //health level that get all persons
    private final int HEALTH = 10;

    //list of heroes
    private final List<Hero> heroes = List.of(
            new Mage("Gandalf", HEALTH),
            new Warrior("Artes", HEALTH),
            new Archer("Legolas", HEALTH)
    );

    //list of enemies
    private final List<Enemy> enemies = List.of(
            new Pinocchio("Pinochet", HEALTH),
            new WiniThePooh("BearTheTerrible", HEALTH),
            new Cheburashka("Ubivachka", HEALTH)
    );

    public static void main(String[] args) {
        var arena = new BattleGround();
        arena.startChampionship();

    }

    //all heroes will fight with all enemies
    private void startChampionship() {
        //for each hero start a battle with each enemy
        heroes.forEach(hero -> enemies.forEach(enemy -> makeBattle(hero.copy(), enemy.copy()))); //create copy of hero and enemy object
    }

    //one round of fighting
    private void makeBattle(Hero hero, Enemy enemy) {
        String START_BATTLE = "FIGHT";
        System.out.println(START_BATTLE);
        while (true) {                      //fight is going while both opponents have health more 0.
            hero.attackEnemy(enemy);        //hero attack first
            if (!enemy.isAlive()) break;    //if enemy is killed then finish the fight
            enemy.attack(hero);             //enemy attack
            if (!hero.isAlive()) break;
        }
        nameWinner(hero, enemy);

    }

    //printing the winner
    private void nameWinner(Hero hero, Enemy enemy) {
        String winner;
        String WINNER_ANNOUNCING = "%s is winner!!!\n";
        if (hero.isAlive()) {              //checks if hero is alive
            winner = hero.getNAME();
        } else {                            //else winner is enemy
            winner = enemy.getClass().getSimpleName();
        }
        System.out.printf(WINNER_ANNOUNCING, winner);
        System.out.println("________________________");
        try {
            TimeUnit.SECONDS.sleep(3);        //timeout between fighting
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
