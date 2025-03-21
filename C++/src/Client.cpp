#include "Client.h"

Client::Client(string n) : name(n), nonBankFunds(0) {}

void Client::depositMoney(double amount) {
  amount = checkIfNegative(amount);
  if (amount > nonBankFunds) {
    cout << "Insufficient Balance";
    return;
  }
  account.deposit(amount);
  nonBankFunds -= amount;
}

void Client::withdrawMoney(double amount) {
  amount = checkIfNegative(amount);
  if (account.getBalance() >= amount) {
    account.withdraw(amount);
    nonBankFunds += amount;
  } else {
    cout << "Insufficient balance\n";
  }
}

double Client::getAccountBalance() { return account.getBalance(); }

void Client::displayPortfolio() {
  if (portfolio.empty()) {
    cout << "No investments yet." << endl;
  } else {
    for (auto &investment : portfolio) {
      cout << investment.type << ", " << investment.amount << "$, duration "
           << investment.duration << " months, risk: " << investment.risk
           << ", return: " << investment.returnRate * 100 << "%" << endl;
    }
  }
  cout << "Portfolio: " << nonBankFunds << "$" << endl;
}

void Client::addInvestment(Investment investment) {
  if (account.hasDebt()) {
    cout << "Cannot invest with outstanding debt." << endl;
    return;
  }
  portfolio.push_back(investment);
}

void Client::advanceTime() {
  nonBankFunds += 100;
  for (auto &investment : portfolio) {
    if (investment.duration > 0) {
      investment.duration--;
      if (investment.duration == 0) {
        cout << "The " << investment.type << " investment has matured!" << endl;
        account.deposit(investment.executeInvestment());
      }
    }
  }
}

double Client::getNonBankFunds() const { return nonBankFunds; }

double Client::checkIfNegative(double amount) {
  if (amount < 0) {
    return amount * -1;
  } else {
    return amount;
  }
}