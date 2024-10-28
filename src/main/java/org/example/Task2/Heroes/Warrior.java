package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;

public class Warrior extends Hero {

    //the strength of attack
    private final int STRENGTH = 7;

    public Warrior(String name, int health) {
        super(name, health);
    }


    //Warrior doesn't have a special attack, It doesn't matter who he chops down.
    // He has a bonus for health.
    @Override
    public void attackEnemy(Enemy enemy) {
        var attackClaim = "Warrior %s is attacking!\n";
        var healingClaim = "I am blessed.";
        var healthBonus = 2;

        if (getHealth() <= STRENGTH) {    //if health less or equal STRENGTH, increase health with health bonus
            setHealth(getHealth() + healthBonus);
            System.out.println(healingClaim);
        }
        System.out.printf(attackClaim, getNAME());
        enemy.takeDamage(STRENGTH);
    }

}

