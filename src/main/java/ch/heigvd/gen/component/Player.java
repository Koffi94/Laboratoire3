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

    /**
     * Play the turn of a the Player, a turn consist of rolling all Die and then moving to another Square.
     */
    public void takeTurn() {
        cup.roll();
        System.out.println(name + " rolled " + cup.getTotal() + " , cash : " + this.getNetWorth());

        // Moving
        Square oldLocation = this.location;
        Square newLocation = board.getSquare(oldLocation, cup.getTotal());
        this.location = newLocation;

        System.out.print(name + " is moving from " + oldLocation.getNumber() + " to " + newLocation.getNumber() + " on");
        this.location.landedOn(this);
        System.out.println();
    }

    /**
     * Add a certain amount of cash to the Player.
     *
     * @param amount the amount of cash to add
     */
    public void addCash(double amount) {
        this.cash += amount;
    }

    /**
     * Remove a certain amount of cash to the Player.
     * @param amount the amount of cash to remove
     * @throws Exception if the cash is going to go below 0
     */
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
