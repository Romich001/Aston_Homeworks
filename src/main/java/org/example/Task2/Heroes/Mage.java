package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Pinocchio;

public class Mage extends Hero {

    private final int STRENGTH = 3;

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        var attackClaim = "Mage %s is attacking!\n";
        if (getHealth() <= STRENGTH) {      //if mage's health is less than it's STRENGTH than mage casts fireball.
            castFireball(enemy);
        } else {
            System.out.printf(attackClaim, getNAME());  //standard attack
            enemy.takeDamage(STRENGTH);
        }

    }

    private void castFireball(Enemy enemy) {
        var damageForPinocchio = 15;       //damage for pinocchio
        var modifierForAttack = 3;
        var attackClaim = " is casting fireball!!!!!!!!!";
        var claimForPinocchio = "Good wood. Dry firewood";

        System.out.println(getNAME() + attackClaim);
        if (enemy instanceof Pinocchio) {            //if enemy is Pinocchio then damage is 15xp. Log is a good fuel.
            enemy.takeDamage(damageForPinocchio);
            System.out.println(claimForPinocchio);
        } else {
            enemy.takeDamage(STRENGTH * modifierForAttack);   //damage to other types of enemies is STRENGTH multiplied to modifier.
        }
    }

}
