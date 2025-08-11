package com.orlovandrei.atm.service.impl;

import com.orlovandrei.atm.annotation.Service;
import com.orlovandrei.atm.exception.DepositLimitExceededException;
import com.orlovandrei.atm.entity.Account;
import com.orlovandrei.atm.service.AccountService;
import com.orlovandrei.atm.service.DepositService;
import com.orlovandrei.atm.service.MiniStatementService;

import java.math.BigDecimal;

import static com.orlovandrei.atm.util.Messages.DEPOSITED;
import static com.orlovandrei.atm.util.Messages.DEPOSIT_LIMIT;
import static com.orlovandrei.atm.util.Messages.DEPOSIT_MUST_BE_POSITIVE;
import static com.orlovandrei.atm.util.Messages.NEW_BALANCE;
import static com.orlovandrei.atm.util.Messages.SUCCESSFULLY_DEPOSITED;

@Service
public class DepositServiceImpl implements DepositService {
    private static DepositServiceImpl instance;
    private final MiniStatementService miniStatementService = MiniStatementServiceImpl.getInstance();
    private final AccountService accountService = AccountServiceImpl.getInstance();

    private DepositServiceImpl() {}

    public static synchronized DepositServiceImpl getInstance() {
        if (instance == null) {
            instance = new DepositServiceImpl();
        }
        return instance;
    }

    @Override
    public void depositAmount(Account account, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println(DEPOSIT_MUST_BE_POSITIVE);
            return;
        }
        try {
            deposit(account, amount);
            System.out.println(amount + SUCCESSFULLY_DEPOSITED);
            accountService.viewBalance(account);
        } catch (DepositLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deposit(Account account, BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("1000000")) <= 0) {
            BigDecimal newBalance = account.getAmount().add(amount);
            account.setAmount(newBalance);
            miniStatementService.addEntry(DEPOSITED + amount + ", " + NEW_BALANCE + newBalance);
            accountService.updateBalance(account, account.getCardData());
        } else {
            throw new DepositLimitExceededException(DEPOSIT_LIMIT);
        }
    }
}
