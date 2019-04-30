package ch.heigvd.gen.core;


import ch.heigvd.gen.component.GoSquare;
import ch.heigvd.gen.component.RegularSquare;
import ch.heigvd.gen.component.Square;

public class Board {
    private Square[] squareTab;

    public Board(int numberOfSquare) {
        this.squareTab = new Square[numberOfSquare];
        initializeBoard();
    }

    public Square getSquare(Square oldLocation, int facevalueTotal) {
        if ((oldLocation.getNumber() + facevalueTotal >= squareTab.length)) {
            return squareTab[squareTab.length - 1];
        }

        if (facevalueTotal < 0 || oldLocation.getNumber() < 0) {
            throw new IndexOutOfBoundsException("Not a valid move");
        }

        return squareTab[oldLocation.getNumber() + facevalueTotal];
    }

    private void initializeBoard() {
        squareTab[0] = new GoSquare("Go", 1);

        for (int i = 1; i < squareTab.length; i++) {
            squareTab[i] = new RegularSquare("Square " + i, i);
        }
    }
}
