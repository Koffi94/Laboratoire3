package ch.heigvd.gen.core;

import ch.heigvd.gen.component.*;

public class MonopolyGame {
    private final int NUMBERS_OF_DIES = 2;
    private final int NUMBERS_OF_ROUNDS = 20;
    private final int NUMBERS_OF_SQUARES = 40;

    private Cup cup;
    private Player[] players;
    private Board board;

    public MonopolyGame(int numberOfPlayers) {
        this.cup = new Cup(NUMBERS_OF_DIES);
        this.players = new Player[numberOfPlayers];
        this.board = new Board(NUMBERS_OF_SQUARES);

        initializePlayers();
    }

    public void playGame() {
        for (int i = 0; i < NUMBERS_OF_ROUNDS; i++) {
            System.out.println("====== Round number : " + (i + 1) + " ======");

            for (int j = 0; j < players.length; j++) {
                playRound(j);
            }
        }
    }

    private void playRound(int indexPlayer) {
        players[indexPlayer].takeTurn();
    }

    private void initializePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("User" + (i + 1), board, cup);
        }
    }
}
