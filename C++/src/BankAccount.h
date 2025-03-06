#ifndef BANK_ACCOUNT_H
#define BANK_ACCOUNT_H

#include <iostream>
using namespace std;

class BankAccount {
private:
  double balance;
  double debt;
  void updateBalance(double amount, bool isDeposit);

public:
  BankAccount();
  void deposit(double amount);
  bool withdraw(double amount);
  double getBalance();
  void updateDebt(double amount);
  void displayAccount();
  bool hasDebt() const;
};

#endif