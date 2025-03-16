package TPSIT_Project_Java.TPSIT_Project_Java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
  private final String username;
  private final String password;
  private final BankAccount account;
  private final List<Investment> portfolio;
  double nonBankFunds;
  private final List<Transaction> transactions = new ArrayList<>();

  public Client(String username, String password) {
    this.username = username;
    this.password = password;
    this.account = new BankAccount();
    this.portfolio = new ArrayList<>();
    this.nonBankFunds = 0;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void depositMoney(double amount) {
    amount = convertMoneyIfNegative(amount);
    if (amount > nonBankFunds) {
      System.out.println("Insufficient Balance");
      return;
    }
    account.deposit(amount);
    nonBankFunds -= amount;
    transactions.add(new Transaction("Deposit", amount));
  }

  public void withdrawMoney(double amount) {
    amount = convertMoneyIfNegative(amount);
    if (account.getBalance() >= amount) {
      account.withdraw(amount);
      nonBankFunds += amount;
      transactions.add(new Transaction("Withdraw", amount));
    } else {
      System.out.println("Insufficient balance.");
    }
  }

  public double getAccountBalance() {
    return account.getBalance();
  }

  public void displayPortfolio() {
    if (portfolio.isEmpty()) {
      System.out.println("No investments yet.");
    } else {
      for (Investment investment : portfolio) {
        System.out.println(
            investment.getType()
                + ", "
                + investment.getAmount()
                + "$, duration "
                + investment.getDuration()
                + " months, risk: "
                + investment.getRisk()
                + ", return: "
                + investment.getReturnRate() * 100
                + "%");
      }
    }
  }

  public void addInvestment(Investment investment) {
    if (account.hasDebt()) {
      System.out.println("Cannot invest with outstanding debt.");
      return;
    }
    portfolio.add(investment);
    transactions.add(new Transaction("Investment", investment.getAmount()));
  }

  public void advanceTime() {
    nonBankFunds += 100;
    for (Investment investment : portfolio) {
      if (investment.getDuration() > 0) {
        investment.setDuration(investment.getDuration() - 1);
        if (investment.getDuration() == 0) {
          System.out.println("The " + investment.getType() + " investment has matured!");
          account.deposit(investment.executeInvestment());
        }
      }
    }
  }

  public double getNonBankFunds() {
    return nonBankFunds;
  }

  public void displayTransactions() {
    if (transactions.isEmpty()) {
      System.out.println("No transactions yet.");
    } else {
      for (Transaction transaction : transactions) {
        System.out.println(
            transaction.getType()
                + ": "
                + transaction.getAmount()
                + "$, "
                + transaction.getTimestamp());
      }
    }
  }

  private double convertMoneyIfNegative(double amount) {
    if (amount < 0) {
      return amount * -1;
    } else {
      return amount;
    }
  }
}
