package com.jfjara.model;

import com.jfjara.rules.RulesExecutor;

public class Game {

    private final Player playerOne;
    private final Player playerTwo;

    private Game(final Player playerOne, final Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public int getTotalHands() {
        return playerOne.getHands().size();
    }

    public Player play() throws InterruptedException {
        for (int i = 0; i < getTotalHands(); i++) {
            System.out.print(playerOne.getHands().get(i).getClass().getSimpleName() + " VS " +
                    playerTwo.getHands().get(i).getClass().getSimpleName() + " -> ");
            int winner = RulesExecutor.compare(playerOne.getHands().get(i), playerTwo.getHands().get(i));
            if (winner != 0) {
                System.out.println("Winner player " + winner);
            } else {
                System.out.println("Draw");
            }
            addPoint(winner);
            Thread.sleep(1000);
        }

        if (playerOne.getPoints() > playerTwo.getPoints())
            return playerOne;
        else if (playerOne.getPoints() < playerTwo.getPoints())
            return playerTwo;
        return null;
    }

    private void addPoint(final int winner) {
        if (winner == 1) {
            playerOne.addPoint();
        } else if (winner == 2) {
            playerTwo.addPoint();
        }
    }

    public static class Builder {

        private Player playerOne;
        private Player playerTwo;

        public Builder playerOne(final Player player) {
            this.playerOne = player;
            return this;
        }

        public Builder playerTwo(final Player player) {
            this.playerTwo = player;
            return this;
        }

        public Game build() {
            return new Game(playerOne, playerTwo);
        }
    }

}
