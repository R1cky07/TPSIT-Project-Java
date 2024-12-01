#ifndef CLIENT_H
#define CLIENT_H

#include <vector>
#include <string>
#include "BankAccount.h"
#include "Investment.h"

class Client {
private:
    std::string name;
    BankAccount account;
    std::vector<Investment> portfolio;

public:
    Client(std::string n);
    void depositMoney(double amount);
    void withdrawMoney(double amount);
    double getAccountBalance();
    void displayPortfolio();
    void addInvestment(Investment investment);
    void advanceTime();
};

#endif
