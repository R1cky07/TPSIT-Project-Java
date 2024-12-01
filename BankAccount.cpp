#include "BankAccount.h"
#include <iostream>
using namespace std;

BankAccount::BankAccount() : balance(0.0), debt(0.0) {}

void BankAccount::deposit(double amount) {
    if (debt > 0) {
        balance -= amount;
        if (balance < 0) balance = 0;
    } else {
        balance += amount;
    }
}

bool BankAccount::withdraw(double amount) {
    if (balance >= amount) {
        balance -= amount;
        return true;
    }
    return false;
}

double BankAccount::getBalance() {
    return balance;
}

void BankAccount::updateDebt(double amount) {
    debt += amount;
    if (debt > balance) {
        balance = 0;
        cout << "Warning! Debt is too high, balance set to zero." << endl;
    }
}

void BankAccount::displayAccount() {
    cout << "Bank account balance: " << balance << "€" << endl;
}
