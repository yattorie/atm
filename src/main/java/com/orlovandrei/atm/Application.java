package com.orlovandrei.atm;

import com.orlovandrei.atm.api.ATMApp;

public class Application {
    public static void main( String[] args )
    {
        ATMApp atmApp = new ATMApp();
        atmApp.startATM();
    }
}
