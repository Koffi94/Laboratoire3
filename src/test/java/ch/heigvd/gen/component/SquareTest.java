package ch.heigvd.gen.component;

import ch.heigvd.gen.core.Board;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testAllSquare() {
        Player testPlayer = new Player("testPlayer", new Board(40), new Cup(2));
        IncomeTaxSquare regularSquare = new IncomeTaxSquare("", 0);
        JailSquare jailSquare = new JailSquare("", 0);
        GoToJailSquare goToJailSquare = new GoToJailSquare("", 0, jailSquare);

        regularSquare.landedOn(testPlayer);
        goToJailSquare.landedOn(testPlayer);

        // Source: https://stackoverflow.com/questions/1196192/how-to-read-the-value-of-a-private-field-from-a-different-class-in-java
        Field f = null; //NoSuchFieldException

        try {
            f = testPlayer.getClass().getDeclaredField("location");
            f.setAccessible(true);

            assertEquals(f.get(testPlayer), jailSquare);
            assertFalse(testPlayer.getNetWorth() == 1500);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}