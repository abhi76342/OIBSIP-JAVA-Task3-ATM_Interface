# ATM Application README

Welcome to the ATM Application! This console-based Java application provides a user-friendly interface for basic banking operations, including registration, login, and various transactions.

## Features

### 1. Registration and Login

- **Register (Option 1):**
  - Enter your account number, user name, and password.
  - Registration is successful! You can now log in.

- **Login (Option 2):**
  - Enter your user name and password.
  - Login is successful.
  - In case of invalid credentials, you'll be prompted to try again.

### 2. Main Menu

Once logged in, you have access to the following transactions:

- **Transactions History (Option 1):**
  - View your transaction history.

- **Withdraw (Option 2):**
  - Enter the amount to withdraw from your account.
  - Withdrawal is successful.

- **Deposit (Option 3):**
  - Enter the amount to deposit into your account.
  - Deposit is successful.

- **Transfer (Option 4):**
  - Enter the recipient's name and the amount to transfer.
  - Transfer is successful.

- **Check Balance (Option 5):**
  - View your account balance.

- **Quit (Option 6):**
  - Exit the application.

### 3. Exit

- **Exit (Option 3):**
  - Exit the application.

## Getting Started

1. **Registration:**
   - Select option 1.
   - Provide your account number, user name, and password.

2. **Login:**
   - Choose option 2.
   - Enter your user name and password.

3. **Perform Transactions:**
   - After a successful login, choose from options 1 to 6.

4. **Exiting:**
   - To exit the application, choose option 3 at any point.

## Example Usage

```plaintext
===============!! Welcome to ATM !!===============

1. Register
2. Login
3. Exit

Enter your choice: 1

Enter Your Account Number: 123456
Enter Your User Name: john_doe
Enter Your Password: password

Registration Successful! Please log in.

1. Register
2. Login
3. Exit

Enter your choice: 2

Enter Your User Name: john_doe
Enter Your Password: password

Login Successful!

1. Transactions History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit

Enter your choice: 2

Enter Amount to Withdraw: 100

Withdrawal successful!

1. Transactions History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit

Enter your choice: 5

Available balance is 9900.0 Rs.

1. Transactions History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Quit

Enter your choice: 6

Exiting...
```

## Working of Choices

### 1. Transactions History

- Displays a list of all transactions made by the user.

### 2. Withdraw

- User inputs the amount to withdraw.
- If the balance is sufficient, the specified amount is withdrawn.
- A success message is displayed, or an insufficient balance message is shown.

### 3. Deposit

- User inputs the amount to deposit.
- The specified amount is added to the account balance.
- A success message is displayed.

### 4. Transfer

- User inputs the recipient's name and the amount to transfer.
- If the balance is sufficient, the specified amount is transferred.
- A success message is displayed, or an insufficient balance message is shown.

### 5. Check Balance

- Displays the current account balance.

### 6. Quit

- Exits the application.

Explore the ATM Application to manage your account effortlessly!

**Note:** This is a simple simulation, and no real transactions are performed.
