package Source;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {
  private final String type;
  private final double amount;
  private final LocalDateTime timestamp;

  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.timestamp = LocalDateTime.now();
  }

  public String getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }

  public String getTimestamp() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return timestamp.format(formatter);
  }
}
