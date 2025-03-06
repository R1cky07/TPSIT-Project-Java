#ifndef INVESTMENT_H
#define INVESTMENT_H

#include <iostream>
#include <string>
using namespace std;

class Investment {
public:
  std::string type;
  double amount;
  int duration;
  std::string risk;
  double returnRate;

  Investment(string t, double a, string r, double rr);
  double executeInvestment();
};

#endif