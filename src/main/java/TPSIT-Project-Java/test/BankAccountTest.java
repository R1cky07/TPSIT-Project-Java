import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

  private BankAccount account;

  @BeforeEach
  void setUp() {
    account = new BankAccount();
  }

  @Test
  void testDeposit() {
    account.deposit(100.0);
    assertEquals(100.0, account.getBalance(), "Deposit should increase balance by 100.0");
  }

  @Test
  void testWithdrawSufficientBalance() {
    account.deposit(100.0);
    assertTrue(account.withdraw(50.0), "Withdrawal should succeed with sufficient balance");
    assertEquals(50.0, account.getBalance(), "Balance should be 50.0 after withdrawal");
  }

  @Test
  void testWithdrawInsufficientBalance() {
    account.deposit(50.0);
    assertFalse(account.withdraw(100.0), "Withdrawal should fail with insufficient balance");
    assertEquals(50.0, account.getBalance(), "Balance should remain unchanged");
  }
}
