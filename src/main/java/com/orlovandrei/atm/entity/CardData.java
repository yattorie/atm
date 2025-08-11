package com.orlovandrei.atm.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardData {
    String cardNumber;
    String pinCode;
    int failedAttempts;
    LocalDateTime blockTimestamp;

    public CardData(String cardNumber, String pinCode) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.failedAttempts = 0;
        this.blockTimestamp = null;
    }
}
