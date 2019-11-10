package com.sparta.wla.exceptions;

public class SimulationException extends Exception {

    private String message;

    public SimulationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
