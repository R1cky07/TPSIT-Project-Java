package com.tpsit.progettoJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

  private Client client;

  @BeforeEach
  void setUp() {
    client = new Client("testUser", "testPassword");
  }

  @Test
  void testDepositMoney() {
    client.depositMoney(100.0);
    assertEquals(
        0.0,
        client.getAccountBalance(),
        "Account balance should remain 0.0 because there are no funds in the wallet");
    client.nonBankFunds = 200.0;
    client.depositMoney(100.0);
    assertEquals(
        100.0, client.getAccountBalance(), "Account balance should be 100.0 after deposit");
    assertEquals(100.0, client.getNonBankFunds(), "Non-bank funds should be 100.0 after deposit");
  }

  @Test
  void testWithdrawMoneySufficientBalance() {
    client.nonBankFunds = 200.0;
    client.depositMoney(100.0);
    client.withdrawMoney(50.0);
    assertEquals(
        50.0, client.getAccountBalance(), "Account balance should be 50.0 after withdrawal");
    assertEquals(
        150.0, client.getNonBankFunds(), "Non-bank funds should be 150.0 after withdrawal");
  }

  @Test
  void testWithdrawMoneyInsufficientBalance() {
    client.nonBankFunds = 200.0;
    client.depositMoney(50.0);
    client.withdrawMoney(100.0);
    assertEquals(50.0, client.getAccountBalance(), "Account balance should remain unchanged");
    assertEquals(150.0, client.getNonBankFunds(), "Non-bank funds should remain unchanged");
  }
}
