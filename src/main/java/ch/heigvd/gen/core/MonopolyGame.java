package ch.heigvd.gen.core;
import ch.heigvd.gen.component.*;

public class MonopolyGame {
    private Die[] dies;
    private Player[] players;
    private Board board;
    private int nbRounds;


    public MonopolyGame(int NbDies, int NbPlayers, int nbRounds) {
        this.dies = new Die[NbDies];
        this.players = new Player[NbPlayers];
        this.nbRounds = nbRounds;
        this.board = new Board();
    }

    public void playGame() {
        for (int i = 0; i < nbRounds; i++) {
            playRound(i);
        }
    }

    private void playRound(int indexPlayer) {
        players[indexPlayer].takeTurn();
    }


}
