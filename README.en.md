# 🏦 ATM

---

A Java application that simulates the functionality of an ATM machine.  
Allows users to check balances, withdraw and deposit funds, view mini statements, and ensures secure card validation with blocking mechanisms.

---

## 💡 Functionality

- **Check Balance**: View the available balance in your account.
- **Withdraw Funds**: Withdraw cash with built-in validation (amount must be a multiple of 50 and within your balance).
- **Deposit Funds**: Deposit money with validation (positive amount, up to 1,000,000 rubles).
- **View Mini Statement**: See your recent transactions for quick account insights.
- **Card Validation**: Enter a valid card number and PIN; user data is verified against stored values.
- **Card Blocking**: After three failed PIN attempts, your card is blocked for 24 hours.

---

## 📝 Menu Options

1. **Check Balance** — Displays your current account balance.
2. **Withdraw Funds** — Request a withdrawal; input must be a multiple of 50 and within the available balance.
3. **Deposit Funds** — Request a deposit; input must be positive and not exceed 1,000,000 rubles.
4. **View Mini Statement** — Shows your latest transactions.
5. **Exit** — Close the application.

---

## ⚙️ Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yattorie/atm.git
   cd atm
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.orlovandrei.atm.App"
   ```
   or for Windows:
   ```bat
   bat.bat
   ```

---

## 🕹 How to Use

1. Start the application.
2. Enter the required card data, which is stored in `resources/card_data.txt`  
   *(Format: card number XXXX-XXXX-XXXX-XXXX, PIN code, balance, login attempts, blocked status — `0` means not blocked, a date means blocked until that date).*
3. After successful login, use the menu to perform the desired operations.

---

## 🧑‍💻 Contacts

- Author: [yattorie](https://github.com/yattorie)
