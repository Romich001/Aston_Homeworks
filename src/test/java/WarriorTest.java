import org.example.Task2.Enemy.Cheburashka;
import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Heroes.Hero;
import org.example.Task2.Heroes.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Hero warrior;
    Enemy enemy;
    @BeforeEach
    void setUp() {
        enemy = new Cheburashka("Ushastik", 10);
        warrior = new Warrior("Warrior", 10);
    }

    @Test
    void attackEnemy() {
        warrior.attackEnemy(enemy);
        assertEquals(3, enemy.getHealth());
    }

    @Test
    void healingTest() {
        warrior.setHealth(7);  //if warrior have hp less or equal his strength then he is healing.
        warrior.attackEnemy(enemy);
        assertEquals(9, warrior.getHealth());
    }
}