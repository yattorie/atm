package com.orlovandrei.atm.service;

import com.orlovandrei.atm.model.Account;

import java.math.BigDecimal;

public interface WithdrawService {

    void withdrawAmount(Account account, BigDecimal amount);
}
