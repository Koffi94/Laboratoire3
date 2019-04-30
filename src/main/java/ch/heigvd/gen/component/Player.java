package ch.heigvd.gen.component;

import ch.heigvd.gen.core.Board;

public class Player {
    private String name;
    private Board board;
    private Cup cup;
    private double cash;
    private Square location;

    public Player(String name, Board board, Cup cup) {
        this.name = name;
        this.board = board;
        this.cup = cup;
        this.cash = 1500;
        this.location = new GoSquare("Go", 1);
    }

    public void takeTurn() {
        cup.roll();
        System.out.println(name + " rolled " + cup.getTotal());

        // Moving
        Square oldLocation = this.location;
        Square newLocation = board.getSquare(oldLocation, cup.getTotal());
        this.location = newLocation;

        System.out.println(name + " is moving from " + oldLocation.getNumber() + " to " + newLocation.getNumber() + "\n");
    }

    public void addCash(double amount) {
        this.cash += amount;
    }

    public void reduceCash(double amount) throws Exception {
        if (this.cash - amount < 0) {
            throw new Exception("Not enough money");
        }

        this.cash -= amount;
    }

    public double getNetWorth() {
        return this.cash;
    }

    public void setLocation(Square square) {
        this.location = square;
    }
}
