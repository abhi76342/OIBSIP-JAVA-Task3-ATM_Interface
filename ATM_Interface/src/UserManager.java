
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String USER_DATA_FILE = "userData.dat";

    private Map<String, BankAccount> userAccounts;

    public UserManager() {
        userAccounts = new HashMap<>();
    }

    public void registerUser(String username, BankAccount bankAccount) {
        userAccounts.put(username, bankAccount);
        saveUserData();
    }

    public BankAccount loginUser(String username, String password) {
        BankAccount user = userAccounts.get(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    private void saveUserData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static UserManager loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA_FILE))) {
            return (UserManager) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new UserManager();
        }
    }

    public static UserManager initialize() {
        return loadUserData();
    }
}
