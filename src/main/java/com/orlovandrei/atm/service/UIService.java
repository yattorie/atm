package com.orlovandrei.atm.service;

import com.orlovandrei.atm.model.Account;

public interface UIService {

    void viewBalance(Account account);

    void viewMiniStatement();

    void handleWithdrawal(Account account);

    int getMenuOption();

    void handleDeposit(Account account);
}
