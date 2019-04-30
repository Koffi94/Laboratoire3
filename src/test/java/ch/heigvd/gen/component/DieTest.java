package ch.heigvd.gen.component;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    @RepeatedTest(10)
    void dieTest() {
        Integer tab[] = new Integer[]{1, 2, 3, 4, 5, 6};
        List<Integer> possibleDiceValue = Arrays.asList(tab);

        Die die = new Die(0);

        die.roll();
        assertTrue(possibleDiceValue.contains(die.getFaceValue()));
    }
}