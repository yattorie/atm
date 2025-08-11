package com.orlovandrei.atm.api;

import com.orlovandrei.atm.entity.Account;
import com.orlovandrei.atm.service.AccountService;
import com.orlovandrei.atm.service.CardService;
import com.orlovandrei.atm.service.UIService;
import com.orlovandrei.atm.service.impl.AccountServiceImpl;
import com.orlovandrei.atm.service.impl.CardServiceImpl;
import com.orlovandrei.atm.service.impl.UIServiceImpl;
import com.orlovandrei.atm.util.AtmScanner;

import java.util.List;

import static com.orlovandrei.atm.util.Messages.CARD_NOT_FOUND;
import static com.orlovandrei.atm.util.Messages.ENTER_CARD_NUMBER;
import static com.orlovandrei.atm.util.Messages.ERROR_READING_CARD_DATA;
import static com.orlovandrei.atm.util.Messages.EXITING_THE_SYSTEM;
import static com.orlovandrei.atm.util.Messages.INVALID_CARD_NUMBER_FORMAT;
import static com.orlovandrei.atm.util.Messages.INVALID_OPERATION_CHOICE;
import static com.orlovandrei.atm.util.Messages.PICK_UP_CARD;
import static com.orlovandrei.atm.util.Messages.THANK_YOU;
import static com.orlovandrei.atm.util.Messages.WELCOME_MESSAGE;

public class ATMApp {
    private final CardService cardService = CardServiceImpl.getInstance();
    private final UIService uiService = UIServiceImpl.getInstance();
    private final AccountService accountService = AccountServiceImpl.getInstance();
    private final AtmScanner atmScanner = AtmScanner.getInstance();

    public void startATM() {
        System.out.println(WELCOME_MESSAGE);
        System.out.print(ENTER_CARD_NUMBER);
        String cardNumber = atmScanner.getScanner().next();
        if (!cardService.isValidCardNumberFormat(cardNumber)) {
            System.out.println(INVALID_CARD_NUMBER_FORMAT);
            return;
        }

        List<String[]> dataList;
        try {
            dataList = cardService.readDataFromFile();
        } catch (RuntimeException e) {
            System.out.println(ERROR_READING_CARD_DATA + e.getMessage());
            return;
        }

        boolean cardExists = cardService.cardExists(cardNumber, dataList);
        if (!cardExists) {
            System.out.println(CARD_NOT_FOUND);
            return;
        }

        String pinCode = cardService.getValidPinCode(cardNumber);
        Account account = accountService.initializeAccount(cardNumber, pinCode);

        while (true) {
            int choice = uiService.getMenuOption();
            switch (choice) {
                case 1:
                    uiService.viewBalance(account);
                    break;
                case 2:
                    uiService.handleWithdrawal(account);
                    break;
                case 3:
                    uiService.handleDeposit(account);
                    break;
                case 4:
                    uiService.viewMiniStatement();
                    break;
                case 5:
                    System.out.println(PICK_UP_CARD);
                    System.out.println(EXITING_THE_SYSTEM);
                    System.out.println(THANK_YOU);
                    return;
                default:
                    System.out.println(INVALID_OPERATION_CHOICE);
            }
        }
    }
}
