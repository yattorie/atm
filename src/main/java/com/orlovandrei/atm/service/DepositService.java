package com.orlovandrei.atm.service;

import com.orlovandrei.atm.entity.Account;

import java.math.BigDecimal;

public interface DepositService {

    void depositAmount(Account account, BigDecimal amount);
}
