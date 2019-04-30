package ch.heigvd.gen.main;

import ch.heigvd.gen.core.MonopolyGame;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Please enter number of players (2-8) : ");

        Scanner userInput = new Scanner(System.in);
        int numberOfPlayers = userInput.nextInt();

        while (numberOfPlayers > 9 || numberOfPlayers < 2) {
            System.out.println("Please, enter a valid number of player (2-8) : ");
            numberOfPlayers = userInput.nextInt();
        }

        MonopolyGame game = new MonopolyGame(numberOfPlayers);
        game.playGame();
    }
}
