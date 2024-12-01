#include "Investment.h"

Investment::Investment(std::string t, double a, int d, std::string r, double rr)
    : type(t), amount(a), duration(d), risk(r), returnRate(rr) {}

double Investment::executeInvestment() {
    return amount * (1 + returnRate);
}
