package com.orlovandrei.atm.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CardData {
    private String cardNumber;
    private String pinCode;
    private int failedAttempts;
    private LocalDateTime blockTimestamp;

    public CardData(String cardNumber, String pinCode) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.failedAttempts = 0;
        this.blockTimestamp = null;
    }
}
