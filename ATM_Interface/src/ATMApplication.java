import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ATMApplication {
    private static final String USERS_DATA_FILE = "users.dat";

    public static void main(String[] args) {
        UserManager userManager = loadUserData();

        Scanner scanner = new Scanner(System.in);

        System.out.println("================!! Welcome to ATM !!================");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(userManager);
                    break;
                case 2:
                    login(userManager);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    saveUserData(userManager);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(UserManager userManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Your User Name:");
        String username = scanner.nextLine();
        System.out.println("Enter Your Password:");
        String password = scanner.nextLine();
        System.out.println("Enter Your Account Number:");
        String accountNo = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(name, username, password, accountNo);
        userManager.registerUser(username, bankAccount);

        System.out.println("Registration Successful. Please log in.");
    }

    private static void login(UserManager userManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your User Name:");
        String username = scanner.nextLine();
        System.out.println("Enter Your Password:");
        String password = scanner.nextLine();

        BankAccount user = userManager.loginUser(username, password);

        if (user != null) {
            System.out.println("Login Successful!");
            interactWithATM(user);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void interactWithATM(BankAccount user) {
        Scanner scanner = new Scanner(System.in);
        boolean isFinished = false;

        while (!isFinished) {
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.transactionHistory();
                    break;
                case 2:
                    System.out.println("Enter Amount to Withdraw:");
                    float withdrawAmount = scanner.nextFloat();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter Amount to Deposit:");
                    float depositAmount = scanner.nextFloat();
                    user.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Enter Recipient Name:");
                    scanner.nextLine(); // Consume the newline
                    String recipient = scanner.nextLine();
                    System.out.println("Enter Amount to Transfer:");
                    float transferAmount = scanner.nextFloat();
                    user.transfer(recipient, transferAmount);
                    break;
                case 5:
                    System.out.println("Your Balance: " + user.checkBalance() + " Rs.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    isFinished = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static UserManager loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_DATA_FILE))) {
            return (UserManager) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If file not found or class not found, return a new UserManager
            return UserManager.initialize();
        }
    }

    private static void saveUserData(UserManager userManager) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_DATA_FILE))) {
            oos.writeObject(userManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
