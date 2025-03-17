package com.orlovandrei.atm.service;

import com.orlovandrei.atm.model.Account;

import java.math.BigDecimal;

public interface DepositService {

    void depositAmount(Account account, BigDecimal amount);
}
