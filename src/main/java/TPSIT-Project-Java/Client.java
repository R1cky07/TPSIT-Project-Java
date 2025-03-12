import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private BankAccount account;
    private List<Investment> portfolio;
    private double nonBankFunds;
    private int monthsPassed;

    public Client(String name) {
        this.name = name;
        this.account = new BankAccount();
        this.portfolio = new ArrayList<>();
        this.nonBankFunds = 0;
        this.monthsPassed = 0;
    }

    public void depositMoney(double amount) {
        if (amount > nonBankFunds) {
            System.out.println("Insufficient Balance");
            return;
        }
        account.deposit(amount);
        nonBankFunds -= amount;
    }

    public void withdrawMoney(double amount) {
        if (!account.withdraw(amount)) {
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
                System.out.println(investment.getType() + ", " + investment.getAmount() + "$, duration "
                        + investment.getDuration() + " months, risk: " + investment.getRisk()
                        + ", return: " + investment.getReturnRate() * 100 + "%");
            }
        }
        System.out.println("Portfolio: " + nonBankFunds + "$");
    }

    public void addInvestment(Investment investment) {
        if (account.hasDebt()) {
            System.out.println("Cannot invest with outstanding debt.");
            return;
        }
        portfolio.add(investment);
    }

    public void advanceTime() {
        monthsPassed++;
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
}