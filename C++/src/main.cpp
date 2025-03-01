#include <iostream>
#include "Client.h"
#include "Client.cpp"
#include "Investment.h"
#include "Investment.cpp"
#include "BankAccount.h"
#include "BankAccount.cpp"

using namespace std;

int main() {
    srand(static_cast<unsigned>(time(0)));

    Client client1("John Doe");

    int choice;

    do {
        cout << "\nMenu:\n";
        cout << "1. Deposit money\n";
        cout << "2. Withdraw money\n";
        cout << "3. View bank account balance\n";
        cout << "4. View investment portfolio\n";
        cout << "5. Add investment\n";
        cout << "6. Advance time (1 month)\n";
        cout << "7. Exit\n";
        cout << "Choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                double amount;
                cout << "How much money would you like to deposit? ";
                cin >> amount;
                client1.depositMoney(amount);
                break;
            }
            case 2: {
                double amount;
                cout << "How much money would you like to withdraw? ";
                cin >> amount;
                client1.withdrawMoney(amount);
                break;
            }
            case 3: {
                cout << "Account Balance: " << client1.getAccountBalance() << "€" << endl;
                break;
            }
            case 4: {
                client1.displayPortfolio();
                break;
            }
            case 5: {
                string investmentType, risk;
                int duration;
                double amount, returnRate;

                cout << "Investment type (short/medium/long): ";
                cin >> investmentType;
                cout << "Investment duration in months: ";
                cin >> duration;
                cout << "Risk level (low/medium/high): ";
                cin >> risk;

                if (risk == "low") {
                    returnRate = 0.05;
                } else if (risk == "medium") {
                    returnRate = 0.1;
                } else if (risk == "high") {
                    returnRate = 0.2;
                } else {
                    cout << "Invalid risk level (set it medium)\n";
                    returnRate = 0.1;
                }

                cout << "Amount to invest: ";
                cin >> amount;

                Investment newInvestment(investmentType, amount, duration, risk, returnRate);
                client1.addInvestment(newInvestment);
                break;
            }
            case 6: {
                client1.advanceTime();
                break;
            }
            case 7: {
                cout << "Goodbye!" << endl;
                break;
            }
            default: {
                cout << "Invalid choice. Please try again." << endl;
                break;
            }
        }
    } while (choice != 7);

    return 0;
}
