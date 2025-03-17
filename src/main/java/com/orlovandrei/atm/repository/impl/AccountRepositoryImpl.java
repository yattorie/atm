package com.orlovandrei.atm.repository.impl;

import com.orlovandrei.atm.annotation.Repository;
import com.orlovandrei.atm.util.DataManager;
import com.orlovandrei.atm.model.Account;
import com.orlovandrei.atm.model.CardData;
import com.orlovandrei.atm.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private static AccountRepositoryImpl instance;
    private final DataManager dataManager = DataManager.getInstance();

    private AccountRepositoryImpl() {}

    public static synchronized AccountRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AccountRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Account findAccountByCardNumberAndPinCode(String cardNumber, String pinCode) {
        List<String[]> dataList = dataManager.readDataFromFile();
        for (String[] data : dataList) {
            if (data[0].equals(cardNumber) && data[1].equals(pinCode)) {
                CardData cardData = new CardData(cardNumber, pinCode);
                Account account = new Account(cardData);
                account.setAmount(new BigDecimal(data[2]));
                return account;
            }
        }
        return null;
    }

    @Override
    public void updateBalance(String cardNumber, String pinCode, BigDecimal newBalance) {
        List<String[]> dataList = dataManager.readDataFromFile();
        for (String[] data : dataList) {
            if (data[0].equals(cardNumber) && data[1].equals(pinCode)) {
                data[2] = newBalance.toString();
                break;
            }
        }
        dataManager.writeDataToFile(dataList);
    }
}
