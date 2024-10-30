import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Pinocchio;
import org.example.Task2.Heroes.Hero;
import org.example.Task2.Heroes.Mage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {

    private Hero mage;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        mage = new Mage("Mage", 4);
        enemy = new Pinocchio("Enemy", 10);
    }


    @Test
    @DisplayName("Standard mage attack.")
    void attackEnemy() {
        mage.attackEnemy(enemy);
        assertEquals(7, enemy.getHealth());
    }

    @Test
    @DisplayName("Mage cast fireball.")
    void castFireball() {
        mage.setHealth(3);   //to make a special attack the health of mage should be less his strength
        mage.attackEnemy(enemy);
        assertEquals(-5, enemy.getHealth());

    }
}