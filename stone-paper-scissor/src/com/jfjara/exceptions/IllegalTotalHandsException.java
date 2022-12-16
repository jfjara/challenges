package com.jfjara.exceptions;

public class IllegalTotalHandsException extends RuntimeException {

    public IllegalTotalHandsException() {
        super("Total number of hands game <= 0");
    }
}
