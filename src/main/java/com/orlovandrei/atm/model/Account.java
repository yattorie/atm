package com.orlovandrei.atm.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class Account {
    private BigDecimal amount = BigDecimal.ZERO;
    private final CardData cardData;
}
