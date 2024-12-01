#include "Client.h"
#include <iostream>

Client::Client(std::string n) : name(n) {}

void Client::depositMoney(double amount) {
    account.deposit(amount);
}

void Client::withdrawMoney(double amount) {
    if (!account.withdraw(amount)) {
        std::cout << "Insufficient balance." << std::endl;
    }
}

double Client::getAccountBalance() {
    return account.getBalance();
}

void Client::displayPortfolio() {
    std::cout << "Investment Portfolio:" << std::endl;
    if (portfolio.empty()) {
        std::cout << "No investments yet." << std::endl;
    } else {
        for (auto &investment : portfolio) {
            std::cout << investment.type << ", " << investment.amount << "€, duration "
                     << investment.duration << " months, risk: " << investment.risk
                     << ", return: " << investment.returnRate * 100 << "%" << std::endl;
        }
    }
}

void Client::addInvestment(Investment investment) {
    portfolio.push_back(investment);
}

void Client::advanceTime() {

    for (auto &investment : portfolio) {
        if (investment.duration > 0) {
            investment.duration--;
            if (investment.duration == 0) {
                std::cout << "The " << investment.type << " investment has matured!" << std::endl;
                account.deposit(investment.executeInvestment());
            }
        }
    }
}
