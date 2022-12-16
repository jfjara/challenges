package com.jfjara.rules;

import com.jfjara.model.Hand;
import com.jfjara.model.Paper;
import com.jfjara.model.Scissor;
import com.jfjara.model.Stone;

public class RulesExecutor {


    public static int compare(final Hand handPlayerOne, final Hand handPlayerTwo) {

        if ((handPlayerOne instanceof Paper && handPlayerTwo instanceof Stone) ||
                (handPlayerOne instanceof Stone && handPlayerTwo instanceof Scissor) ||
                (handPlayerOne instanceof Scissor && handPlayerTwo instanceof Paper)) {
            return 1;
        }
        if ((handPlayerTwo instanceof Paper && handPlayerOne instanceof Stone) ||
                (handPlayerTwo instanceof Stone && handPlayerOne instanceof Scissor) ||
                (handPlayerTwo instanceof Scissor && handPlayerOne instanceof Paper)) {
            return 2;
        }
        return 0;
    }

}
