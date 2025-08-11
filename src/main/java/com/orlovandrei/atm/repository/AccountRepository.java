package com.orlovandrei.atm.repository;

import com.orlovandrei.atm.entity.Account;

import java.math.BigDecimal;

public interface AccountRepository {
    Account findAccountByCardNumberAndPinCode(String cardNumber, String pinCode);
    void updateBalance(String cardNumber, String pinCode, BigDecimal newBalance);
}
