package com.orlovandrei.atm.exception;

public class InvalidWithdrawalException extends RuntimeException {
    public InvalidWithdrawalException(String message) {
        super(message);
    }
}