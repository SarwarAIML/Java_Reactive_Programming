package com.gs.webflux.exception;


public class InputValidationException extends RuntimeException {

    private static final String MSG = "Allowed Range is 10-20";
    private final int errorCode = 10;

    private final int input;

    public InputValidationException(int input) {
        super(MSG);
        this.input = input;
    }

    public int getInput() {
        return input;
    }

    public int getErrorCode() {
        return errorCode;
    }
}