import java.io.*;

public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String username;
    private String password;
    private String accountNo;
    private float balance = 10000f;
    private transient StringBuilder transactionsHistory = new StringBuilder();

    public BankAccount(String name, String username, String password, String accountNo) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountNo = accountNo;
    }

    public void deposit(float amount) {
        balance += amount;
        appendTransaction(amount + " Rs. Deposited");
        System.out.println(amount + " Rs. Successfully Deposited");
    }

    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
            appendTransaction(amount + " Rs. Withdrawn");
            System.out.println(amount + " Rs. Withdrawn Successfully");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void transfer(String recipient, float amount) {
        if (balance >= amount) {
            balance -= amount;
            appendTransaction(amount + " Rs. Transferred to " + recipient);
            System.out.println("Successfully Transferred to " + recipient);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public float checkBalance() {
        return balance;
    }

    public void transactionHistory() {
        if (transactionsHistory.length() == 0) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\nTransaction History:\n" + transactionsHistory.toString());
        }
    }

    private void appendTransaction(String transaction) {
        transactionsHistory.append(transaction).append("\n");
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(transactionsHistory.toString());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        transactionsHistory = new StringBuilder((String) in.readObject());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Other getters and setters as needed
}
