import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataPersistence {
  private static final String DATA_FILE = "users.txt";

  public void saveUsers(Map<String, Client> users) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
      oos.writeObject(users);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Map<String, Client> loadUsers() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
      return (Map<String, Client>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      return new HashMap<>();
    }
  }
}
