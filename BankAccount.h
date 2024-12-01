#ifndef BANK_ACCOUNT_H
#define BANK_ACCOUNT_H

class BankAccount {
private:
    double balance;
    double debt;

public:
    BankAccount();
    void deposit(double amount);
    bool withdraw(double amount);
    double getBalance();
    void updateDebt(double amount);
    void displayAccount();
};

#endif
