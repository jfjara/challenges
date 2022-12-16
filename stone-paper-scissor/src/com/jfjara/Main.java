package com.jfjara;

import com.jfjara.factory.GameFactory;
import com.jfjara.model.Game;
import com.jfjara.model.Player;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = GameFactory.createRandomGame(20);
        Player winner = game.play();
        System.out.println("================================");
        System.out.println("Player 1: " + game.getPlayerOne().getPoints() + " - Player 2: " + game.getPlayerTwo().getPoints());
        if (winner != null) {
            System.out.println("Player " + winner.getNumber() + " is the winner!");
        } else {
            System.out.println("Draw game!");
        }

        System.out.println("================================");

    }



}
