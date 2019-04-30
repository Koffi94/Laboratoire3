package ch.heigvd.gen.component;

import ch.heigvd.gen.core.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void playerTest() {
        Board boardTest = new Board(40);
        Cup cupTest = new Cup(2);
        Player testPlayer = new Player("Player1", boardTest, cupTest);

        testPlayer.addCash(30);
        double firstAssertion = testPlayer.getNetWorth();

        try {
            testPlayer.reduceCash(100);
            double secondAssertion = testPlayer.getNetWorth();

            new IncomeTaxSquare("Square 1", 1).landedOn(testPlayer);
            double thirdAssertion = testPlayer.getNetWorth();

            assertAll(
                    () -> assertEquals(1530.0, firstAssertion),
                    () -> assertEquals(1430.0, secondAssertion),
                    () -> assertEquals(1287.0, thirdAssertion)
            );
        } catch (Exception e) {
            fail();
        }
    }
}