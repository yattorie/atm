package com.orlovandrei.atm.service;

import com.orlovandrei.atm.model.Account;
import com.orlovandrei.atm.model.CardData;

public interface AccountService {

    Account initializeAccount(String cardNumber, String pinCode);

    void viewBalance(Account account);

    void updateBalance(Account account, CardData cardData);
}
