#ifndef CLIENT_H
#define CLIENT_H

#include "BankAccount.h"
#include "Investment.h"
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Client {
private:
  string name;
  BankAccount account;
  vector<Investment> portfolio;
  double nonBankFunds;

public:
  Client(string n);
  void depositMoney(double amount);
  void withdrawMoney(double amount);
  double getAccountBalance();
  void displayPortfolio();
  void addInvestment(Investment investment);
  void advanceTime();
  double getNonBankFunds() const;
};

#endif