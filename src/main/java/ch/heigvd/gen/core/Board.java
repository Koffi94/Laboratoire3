package ch.heigvd.gen.core;


import ch.heigvd.gen.component.*;

public class Board {
    private Square[] squareTab;

    public Board(int numberOfSquare) {
        this.squareTab = new Square[numberOfSquare];
        initializeBoard();
    }

    /**
     * Compute the new Square after a Dice roll.
     *
     * @param oldLocation the actual Square location
     * @param facevalueTotal the value of both Die
     * @return
     */
    public Square getSquare(Square oldLocation, int facevalueTotal) {
        if ((oldLocation.getNumber() + facevalueTotal >= squareTab.length)) {
            return squareTab[squareTab.length - 1];
        }

        if (facevalueTotal < 0 || oldLocation.getNumber() < 0) {
            throw new IndexOutOfBoundsException("Not a valid move");
        }

        return squareTab[oldLocation.getNumber() + facevalueTotal];
    }

    /**
     * Initialize the board by placing specific Square at a fixed position and filling the rest of the Square with
     * Regular Square.
     */
    private void initializeBoard() {
        squareTab[0] = new GoSquare("Go", 0);
        JailSquare jail = new JailSquare("", 0);

        for (int i = 1; i < squareTab.length; i++) {
            if (i == 11) {
                squareTab[i] = new JailSquare("Jail " + i, i);
                jail = (JailSquare) squareTab[i];
            } else if (i == 31) {
                squareTab[i] = new GoToJailSquare("Go To Jail " + i, i, jail);
            } else if (i == 5) {
                squareTab[i] = new IncomeTaxSquare("Income Tax Square " + i, i);
            } else {
                squareTab[i] = new RegularSquare("Regular Square " + i, i);
            }
        }
    }
}
