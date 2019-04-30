package ch.heigvd.gen.core;

import ch.heigvd.gen.component.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board boardTest;
    Square squareTest;

    @BeforeEach
    void initializeBoard() {
        boardTest = new Board(40);
        squareTest = new Square("", 0);
    }

    @Test
    void getSquareTest() {
        // Trying to get out of bounds
        Square result = boardTest.getSquare(squareTest, 80);

        assertEquals(result.getNumber(), new Square("", 39).getNumber());
    }

    @Test
    void getSquareNegativeTest() {
        // Source : https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                boardTest.getSquare(squareTest, -80));
        assertEquals("Not a valid move", exception.getMessage());
    }
}