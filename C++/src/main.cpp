#include "BankAccount.h"
#include "Client.h"
#include "Investment.h"
#include <iostream>

using namespace std;

int main() {
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
    cout << "7. View portfolio\n";
    cout << "8. Exit\n";
    cout << "Choice: ";
    cin >> choice;

	double amount;
    cout << "\n";
    switch (choice) {
    case 1: {
      cout << "How much money would you like to deposit? ";
      cin >> amount;
      client1.depositMoney(amount);
      break;
    }
    case 2: {
      cout << "How much money would you like to withdraw? ";
      cin >> amount;
      client1.withdrawMoney(amount);
      break;
    }
    case 3: {
      cout << "Account Balance: " << client1.getAccountBalance() << "$" << endl;
      break;
    }
    case 4: {
      client1.displayPortfolio();
      break;
    }
    case 5: {
      string investmentType, risk;
	  double returnRate;

      cout << "Investment type (short/medium/long): ";
      cin >> investmentType;
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
      if (amount > client1.getAccountBalance()) {
        cout << "Insufficient balance";
        break;
      }
      Investment newInvestment(investmentType, amount, risk, returnRate);
      client1.addInvestment(newInvestment);
      break;
    }
    case 6: {
      cout << "Advanced of one month...";
      client1.advanceTime();
      break;
    }
    case 7: {
      cout << "Portfolio: " << client1.getNonBankFunds() << "$" << endl;
      break;
    }
    case 8: {
      cout << "Goodbye!" << endl;
      break;
    }
    default: {
      cout << "Invalid choice. Please try again." << endl;
      break;
    }
    }
    cout << "\n";
  } while (choice != 8);

  return 0;
}