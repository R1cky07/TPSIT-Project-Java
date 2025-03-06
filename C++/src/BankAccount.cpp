#include "BankAccount.h"

BankAccount::BankAccount() : balance(0.0), debt(0.0) {}

void BankAccount::updateBalance(double amount, bool isDeposit) {
  if (isDeposit) {
    balance += amount;
  } else {
    balance -= amount;
  }
}

void BankAccount::deposit(double amount) {
  if (debt > 0) {
    double debtRepayment = std::min(amount, debt);
    debt -= debtRepayment;
    amount -= debtRepayment;
    if (debt == 0) {
      cout << "Debt fully repaid." << endl;
    } else {
      cout << "Debt partially repaid (" << debtRepayment
           << "$). Remaining debt: " << debt << "$" << endl;
    }
  }
  updateBalance(amount, true);
}

bool BankAccount::withdraw(double amount) {
  if (balance >= amount) {
    updateBalance(amount, false);
    return true;
  }
  return false;
}

double BankAccount::getBalance() { return balance; }

void BankAccount::updateDebt(double amount) {
  debt += amount;
  if (debt > balance) {
    balance = 0;
    cout << "Warning! Debt is too high, balance set to zero." << endl;
  }
}

void BankAccount::displayAccount() {
  cout << "Bank account balance: " << balance << "$, debt: " << debt << "$"
       << endl;
}

bool BankAccount::hasDebt() const { return debt > 0; }