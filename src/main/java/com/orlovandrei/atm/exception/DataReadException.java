package com.orlovandrei.atm.exception;

public class DataReadException extends RuntimeException {
    public DataReadException(String message, Throwable cause) {
        super(message, cause);
    }
}