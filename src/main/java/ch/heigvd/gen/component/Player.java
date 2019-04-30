package ch.heigvd.gen.component;

import ch.heigvd.gen.core.Board;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Die[] die;

    public Player(String name, Board board, Die[] die) {
        this.name = name;
        this.piece = new Piece(new Square("Go", 0));
        this.board = board;
        this.die = die;
    }

    public void takeTurn() {
        int fvTotal = 0;

        System.out.println("Player : " + name);

        // Rolling
        for (Die d : die) {
            d.roll();
            fvTotal += d.getFaceValue();
            System.out.println("Roll   : " + d.getFaceValue());
        }

        // Moving
        Square oldLocation = piece.getLocation();
        Square newLocation = board.getSquare(oldLocation, fvTotal);
        this.piece.setLocation(newLocation);

        System.out.println("Player : " + name + " is moving from " + oldLocation.getNumber() + " to " + newLocation.getNumber() + "\n");
    }
}
