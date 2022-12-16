package com.jfjara.model;

import java.util.List;

public class Player {

    private final int number;
    private int points;
    private final List<Hand> hands;

    private Player(final int number, final List<Hand> hands) {
        this.points = 0;
        this.hands = hands;
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public int getPoints() {
        return points;
    }

    public List<Hand> getHands() {
        return hands;
    }

    public void addPoint() {
        points++;
    }

    public static class Builder {
        private int number;
        private List<Hand> hands;

        public Builder number(int n) {
            this.number = n;
            return this;
        }

        public Builder hands(List<Hand> hands) {
            this.hands = hands;
            return this;
        }

        public Player build() {
            return new Player(number, hands);
        }

    }


}
