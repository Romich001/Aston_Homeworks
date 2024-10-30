import org.example.Task2.Enemy.Enemy;
import org.example.Task2.Enemy.Pinocchio;
import org.example.Task2.Enemy.WiniThePooh;
import org.example.Task2.Heroes.Archer;
import org.example.Task2.Heroes.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArcherTest {

    private Hero archer;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        archer = new Archer("Archer", 10);
        enemy = new WiniThePooh("Winni", 10);
    }

    @Test
    void attackEnemy() {
        archer.attackEnemy(enemy);
        assertEquals(5, enemy.getHealth());
    }

    @Test
    void attackPinocchio() {
        enemy = new Pinocchio("Pinochet", 10);
        archer.attackEnemy(enemy);
        assertEquals(10, enemy.getHealth());
    }

    @Test
    void specialAttack() {
        archer.setHealth(5);  //special attack is activated when hero health is less or equal his strength
        archer.attackEnemy(enemy);
        assertEquals(0, enemy.getHealth());
    }
}