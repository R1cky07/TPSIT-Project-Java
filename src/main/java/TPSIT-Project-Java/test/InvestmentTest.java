import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ../

class InvestmentTest {

  private Investment investment;

  @BeforeEach
  void setUp() {
    investment = new Investment("short", 1000.0, "medium", 0.1);
  }

  @Test
  void testExecuteInvestment() {
    double result = investment.executeInvestment();
    assertTrue(
        result >= 1000.0 && result <= 1200.0, "Investment result should be within expected range");
  }

  @Test
  void testGetDuration() {
    assertEquals(
        3, investment.getDuration(), "Duration should be 3 months for short-term investment");
  }

  @Test
  void testSetDuration() {
    investment.setDuration(6);
    assertEquals(6, investment.getDuration(), "Duration should be updated to 6 months");
  }
}
