package ch.heigvd.gen.core;

import ch.heigvd.gen.component.RegularSquare;
import ch.heigvd.gen.component.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board boardTest;
    Square squareTest;

    @BeforeEach
    void initializeBoard() {
        boardTest = new Board(40);
        squareTest = new RegularSquare("", 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {80, 88, 5000, Integer.MAX_VALUE})
    void getSquareTest(int faceValue) {
        // Trying to get out of bounds
        Square result = boardTest.getSquare(squareTest, faceValue);

        assertEquals(result.getNumber(), new RegularSquare("", 39).getNumber());
    }

    @Test
    void getSquareNegativeTest() {
        // Source : https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                boardTest.getSquare(squareTest, -80));
        assertEquals("Not a valid move", exception.getMessage());
    }
}