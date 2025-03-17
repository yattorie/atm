package com.orlovandrei.atm.exception;

public class DepositLimitExceededException extends RuntimeException {
    public DepositLimitExceededException(String message) {
        super(message);
    }
}