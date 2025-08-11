package com.orlovandrei.atm.service.impl;

import com.orlovandrei.atm.annotation.Service;
import com.orlovandrei.atm.exception.InsufficientFundsException;
import com.orlovandrei.atm.exception.InvalidWithdrawalException;
import com.orlovandrei.atm.entity.Account;
import com.orlovandrei.atm.service.AccountService;
import com.orlovandrei.atm.service.MiniStatementService;
import com.orlovandrei.atm.service.WithdrawService;

import java.math.BigDecimal;

import static com.orlovandrei.atm.util.Messages.AMOUNT_MULTIPLE_OF_50;
import static com.orlovandrei.atm.util.Messages.INSUFFICIENT_FUNDS;
import static com.orlovandrei.atm.util.Messages.NEW_BALANCE;
import static com.orlovandrei.atm.util.Messages.PLEASE_TAKE_CASH;
import static com.orlovandrei.atm.util.Messages.WITHDRAWAL_MUST_BE_POSITIVE;
import static com.orlovandrei.atm.util.Messages.WITHDREW;

@Service
public class WithdrawServiceImpl implements WithdrawService {
    private static WithdrawServiceImpl instance;
    private final MiniStatementService miniStatementService = MiniStatementServiceImpl.getInstance();
    private final AccountService accountService = AccountServiceImpl.getInstance();

    private WithdrawServiceImpl() {}

    public static synchronized WithdrawServiceImpl getInstance() {
        if (instance == null) {
            instance = new WithdrawServiceImpl();
        }
        return instance;
    }

    @Override
    public void withdrawAmount(Account account, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println(WITHDRAWAL_MUST_BE_POSITIVE);
            return;
        }
        try {
            withdraw(account, amount);
            System.out.println(PLEASE_TAKE_CASH + amount);
            accountService.viewBalance(account);
        }  catch (InsufficientFundsException | InvalidWithdrawalException e) {
            System.out.println(e.getMessage());
        }
    }

    private void withdraw(Account account, BigDecimal amount) {
        if (amount.remainder(new BigDecimal("50")).compareTo(BigDecimal.ZERO) != 0) {
            throw new InvalidWithdrawalException(AMOUNT_MULTIPLE_OF_50);
        }
        if (amount.compareTo(account.getAmount()) > 0) {
            throw new InsufficientFundsException(INSUFFICIENT_FUNDS);
        }
        BigDecimal newBalance = account.getAmount().subtract(amount);
        account.setAmount(newBalance);
        miniStatementService.addEntry(WITHDREW + amount + ", " + NEW_BALANCE + newBalance);
        accountService.updateBalance(account, account.getCardData());
    }
}
