package com.orlovandrei.atm.service.impl;

import com.orlovandrei.atm.annotation.Service;
import com.orlovandrei.atm.exception.InvalidCardOrPinException;
import com.orlovandrei.atm.entity.Account;
import com.orlovandrei.atm.entity.CardData;
import com.orlovandrei.atm.repository.AccountRepository;
import com.orlovandrei.atm.repository.impl.AccountRepositoryImpl;
import com.orlovandrei.atm.service.AccountService;

import static com.orlovandrei.atm.util.Messages.AVAILABLE_BALANCE;
import static com.orlovandrei.atm.util.Messages.INVALID_CARD_OR_PIN;

@Service
public class AccountServiceImpl implements AccountService {
    private static AccountServiceImpl instance;
    private final AccountRepository accountRepository = AccountRepositoryImpl.getInstance();

    private AccountServiceImpl() {}

    public static synchronized AccountServiceImpl getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public Account initializeAccount(String cardNumber, String pinCode) {
        Account account = accountRepository.findAccountByCardNumberAndPinCode(cardNumber, pinCode);
        if (account == null) {
            throw new InvalidCardOrPinException(INVALID_CARD_OR_PIN);
        }
        return account;
    }

    @Override
    public void viewBalance(Account account) {
        System.out.println(AVAILABLE_BALANCE + account.getAmount());
    }

    @Override
    public void updateBalance(Account account, CardData cardData) {
        accountRepository.updateBalance(cardData.getCardNumber(), cardData.getPinCode(), account.getAmount());
    }
}
