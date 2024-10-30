package org.example.Task2.Heroes;

import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Pinocchio;

public class Archer extends Hero {

    private final int STRENGTH = 5;

    public Archer(String name, int health) {

        super(name, health);

    }

    @Override
    public Hero copy() {
        return new Archer(getNAME(), getHealth());
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        var attackClaim = "Archer %s is attacking!\n";
        var attackPinocchioClaim = "My arrows are useless!!! It is just a walking log!!";
        var damageForPinocchio = 0;
        if (getHealth() <= STRENGTH) {    //if health less or equal STRENGTH then use  special attack
            makeLuckyShot(enemy);
        } else {
            if (enemy instanceof Pinocchio) {     // if enemy is Pinocchio then arrows are useless.
                enemy.takeDamage(damageForPinocchio);
                System.out.println(attackPinocchioClaim);
            } else {
                System.out.printf(attackClaim, getNAME());  //usual attack
                enemy.takeDamage(STRENGTH);
            }

        }

    }


    //special attack
    private void makeLuckyShot(Enemy enemy) {
        var damageModifier = 2;
        var attackClaim = "%s hit right in the eye!!!\n";
        enemy.takeDamage(STRENGTH * damageModifier);
        System.out.printf(attackClaim, getNAME());

    }

}
