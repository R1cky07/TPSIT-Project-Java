#include "Investment.h"
#include <cstdlib>
#include <ctime>

Investment::Investment(string t, double a, string r, double rr) {
  type = t;
  if(a < 0){
	  a *= - 1;
  }
  amount = a;
  risk = r;
  returnRate = rr;
  if (t == "short")
    duration = 3;
  if (t == "medium")
    duration = 6;
  if (t == "long")
    duration = 12;
}

double Investment::executeInvestment() {
  double volatility = 0.0;
  if (risk == "low")
    volatility = 0.02;
  else if (risk == "medium")
    volatility = 0.05;
  else if (risk == "high")
    volatility = 0.1;

  double randomFactor = (static_cast<double>(rand()) / RAND_MAX) * 2 - 1;
  double actualReturnRate = returnRate + randomFactor * volatility;

  return amount * (1 + actualReturnRate);
}