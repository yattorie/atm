package com.orlovandrei.atm.service.impl;

import com.orlovandrei.atm.annotation.Service;
import com.orlovandrei.atm.service.MiniStatementService;

import java.util.ArrayList;
import java.util.List;

import static com.orlovandrei.atm.util.Messages.MINI_STATEMENT;
import static com.orlovandrei.atm.util.Messages.NO_TRANSACTIONS_AVAILABLE;

@Service
public class MiniStatementServiceImpl implements MiniStatementService {
    private static MiniStatementServiceImpl instance;

    private final List<String> miniStatement = new ArrayList<>();

    private MiniStatementServiceImpl() {}

    public static synchronized MiniStatementServiceImpl getInstance() {
        if (instance == null) {
            instance = new MiniStatementServiceImpl();
        }
        return instance;
    }

    @Override
    public void viewMiniStatement() {
        if (miniStatement.isEmpty()) {
            System.out.println(NO_TRANSACTIONS_AVAILABLE);
        } else {
            System.out.println(MINI_STATEMENT);
            for (String entry : miniStatement) {
                System.out.println(entry);
            }
        }
    }

    @Override
    public void addEntry(String entry) {
        miniStatement.add(entry);
    }
}
