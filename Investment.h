#ifndef INVESTMENT_H
#define INVESTMENT_H

#include <string>

class Investment {
public:
    std::string type;
    double amount;
    int duration;
    std::string risk;
    double returnRate;

    Investment(std::string t, double a, int d, std::string r, double rr);
    double executeInvestment();
};

#endif
