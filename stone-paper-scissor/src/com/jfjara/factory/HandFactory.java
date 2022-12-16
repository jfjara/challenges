package com.jfjara.factory;

import com.jfjara.exceptions.InvalidTypeOfHandException;
import com.jfjara.model.Hand;
import com.jfjara.model.Paper;
import com.jfjara.model.Scissor;
import com.jfjara.model.Stone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HandFactory {

    public static List<Hand> createRandomHands(final int total) {
        if (total == 0) {
            return null;
        }
        List<Hand> hands = new ArrayList<>();
        for (int i = 0; i < total; i++){
            hands.add(createRandomHand());
        }
        return hands;
    }

    private static Hand createRandomHand() {
        Random random = new Random();
        int randomValue = random.nextInt(3) + 1;
        return switch (randomValue) {
            case 1 -> new Paper();
            case 2 -> new Scissor();
            case 3 -> new Stone();
            default -> throw new InvalidTypeOfHandException();
        };
    }

    public static Hand createHand(final String s) {
        return switch (s) {
            case "P" -> new Paper();
            case "S" -> new Scissor();
            case "R" -> new Stone();
            default -> throw new InvalidTypeOfHandException();
        };
    }
}
