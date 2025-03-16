package TPSIT_Project_Java.TPSIT_Project_Java;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {
  private Map<String, Client> users = new HashMap<>();

  public Client authenticateUser(Scanner scanner) {
    System.out.print("Username: ");
    String username = scanner.next();
    System.out.print("Password: ");
    String password = scanner.next();

    if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
      return users.get(username);
    } else {
      System.out.println("Authentication failed.");
      return null;
    }
  }

  public Client registerUser(Scanner scanner) {
    System.out.print("Enter new username: ");
    String username = scanner.next();
    if (users.containsKey(username)) {
      System.out.println("Username already exists.");
      return null;
    }
    System.out.print("Enter new password: ");
    String password = scanner.next();
    return new Client(username, password);
  }

  public void addUser(Client user) {
    users.put(user.getUsername(), user);
  }

  public void loadUsers(DataPersistence dataPersistence) {
    users = dataPersistence.loadUsers();
  }

  public void saveUsers(DataPersistence dataPersistence) {
    dataPersistence.saveUsers(users);
  }
}
