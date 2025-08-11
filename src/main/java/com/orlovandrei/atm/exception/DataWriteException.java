package com.orlovandrei.atm.exception;

public class DataWriteException extends RuntimeException {
    public DataWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}