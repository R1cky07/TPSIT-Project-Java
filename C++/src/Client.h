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
  std::string name;
  BankAccount account;
  std::vector<Investment> portfolio;
  double nonBankFunds;
  int monthsPassed;

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