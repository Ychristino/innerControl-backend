package com.innerControl.config.validacao;

public class NoSuchItemError extends RuntimeException {

    public NoSuchItemError(String message) {
        super(message);
    }

    public NoSuchItemError(String message, Throwable cause) {
        super(message, cause);
    }
}
