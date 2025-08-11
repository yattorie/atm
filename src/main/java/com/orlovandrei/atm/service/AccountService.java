package com.orlovandrei.atm.service;

import com.orlovandrei.atm.entity.Account;
import com.orlovandrei.atm.entity.CardData;

public interface AccountService {

    Account initializeAccount(String cardNumber, String pinCode);

    void viewBalance(Account account);

    void updateBalance(Account account, CardData cardData);
}
