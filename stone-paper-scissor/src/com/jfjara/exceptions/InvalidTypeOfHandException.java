package com.jfjara.exceptions;

public class InvalidTypeOfHandException extends RuntimeException {

    public InvalidTypeOfHandException() {
        super("Unknown type of hand. Not recognize element.");
    }
}
