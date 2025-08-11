# ATM

## Project Author
### Orlov Andrei

## Description
This ATM Application simulates the functionality of an ATM machine, allowing users to perform various operations such as checking their balance, withdrawing funds, depositing funds, and viewing a mini statement.

## Functionality
- **Check Balance**: Users can check the available balance on their account.
- **Withdraw Funds**: Users can withdraw funds from their account, with necessary validations.
- **Deposit Funds**: Users can deposit funds into their account, with necessary validations.
- **View Mini Statement**: Users can view a mini statement of recent transactions.
- **Card Validation**: The application validates card numbers and PIN codes.
- **Card Blocking**: Cards are blocked after three unsuccessful PIN attempts for 24 hours.

## Menu Options
1. **Check Balance**: Displays the available balance in your account.
2. **Withdraw Funds**: Prompts you to enter an amount to withdraw. The amount must be a multiple of 50 and not exceed the available balance.
3. **Deposit Funds**: Prompts you to enter an amount to deposit. The amount must be positive and not exceed 1,000,000 rubles.
4. **View Mini Statement**: Displays recent transactions.
5. **Exit**: Exits the application.

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yattorie/atm.git
   cd atm-application
   ```

2. Build the project:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn exec:java -Dexec.mainClass="com.orlovandrei.atm.App"
   ```

## Usage
- Start the application.
- Enter the required card data, which are stored in resources/card_data.txt (card format: card number XXXX-XXXX-XXXX-XXXX-XXXX-XXXX, PIN code, amount of money, number of login attempts, blocked or not, at 0 there is no blocking, if there is a date, then the card is blocked).
- After login, perform the necessary operations.
