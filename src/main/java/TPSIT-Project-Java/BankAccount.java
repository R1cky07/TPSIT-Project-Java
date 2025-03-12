public class BankAccount {
    private double balance;
    private double debt;

    public BankAccount() {
        this.balance = 0.0;
        this.debt = 0.0;
    }

    private void updateBalance(double amount, boolean isDeposit) {
        if (isDeposit) {
            balance += amount;
        } else {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (debt > 0) {
            double debtRepayment = Math.min(amount, debt);
            debt -= debtRepayment;
            amount -= debtRepayment;
            if (debt == 0) {
                System.out.println("Debt fully repaid.");
            } else {
                System.out.println("Debt partially repaid (" + debtRepayment
                        + "$). Remaining debt: " + debt + "$");
            }
        }
        updateBalance(amount, true);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            updateBalance(amount, false);
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public void updateDebt(double amount) {
        debt += amount;
        if (debt > balance) {
            balance = 0;
            System.out.println("Warning! Debt is too high, balance set to zero.");
        }
    }

    public void displayAccount() {
        System.out.println("Bank account balance: " + balance + "$, debt: " + debt + "$");
    }

    public boolean hasDebt() {
        return debt > 0;
    }
}
