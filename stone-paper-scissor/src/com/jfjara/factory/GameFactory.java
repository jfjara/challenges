package com.jfjara.factory;

import com.jfjara.exceptions.IllegalTotalHandsException;
import com.jfjara.model.Game;
import com.jfjara.model.Hand;
import com.jfjara.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class GameFactory {
    public static Game createGame(final List<String> inputs) {
        return new Game.Builder()
                .playerOne(new Player.Builder()
                        .number(1)
                        .hands(inputs.stream().map(i -> createHands(1, i)).collect(Collectors.toList()))
                        .build())
                .playerTwo(new Player.Builder()
                        .number(2)
                        .hands(inputs.stream().map(i -> createHands(2, i)).collect(Collectors.toList()))
                        .build())
                .build();
    }

    public static Game createRandomGame(final int totalHands) {

        if (totalHands <= 0) {
            throw new IllegalTotalHandsException();
        }

        return new Game.Builder()
                .playerOne(new Player.Builder()
                        .number(1)
                        .hands(HandFactory.createRandomHands(totalHands))
                        .build())
                .playerTwo(new Player.Builder()
                        .number(2)
                        .hands(HandFactory.createRandomHands(totalHands))
                        .build())
                .build();
    }



    private static Hand createHands(final int i, final String input) {
        var h  = input.split(" ");
        return HandFactory.createHand(h[i - 1]);
    }

}
