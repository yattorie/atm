package com.orlovandrei.atm.util;

import com.orlovandrei.atm.annotation.Utility;

import java.util.Scanner;

@Utility
public class AtmScanner {
    private static AtmScanner instance;
    private Scanner scanner;

    private AtmScanner() {
        scanner = new Scanner(System.in);
    }

    public static synchronized AtmScanner getInstance() {
        if (instance == null) {
            instance = new AtmScanner();
        }
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
