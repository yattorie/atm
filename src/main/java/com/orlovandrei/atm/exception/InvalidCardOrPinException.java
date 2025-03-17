package com.orlovandrei.atm.exception;

public class InvalidCardOrPinException extends RuntimeException {
    public InvalidCardOrPinException(String message) {
        super(message);
    }
}