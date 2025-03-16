package com.tpsit.progettoJava;

import java.io.Serializable;
import java.util.Random;

public class Investment implements Serializable {
  private final String type;
  private final double amount;
  private int duration;
  private final String risk;
  private final double returnRate;

  public Investment(String type, double amount, String risk, double returnRate) {
    this.type = type;
    if (amount < 0) {
      amount *= -1;
    }
    this.amount = amount;
    this.risk = risk;
    this.returnRate = returnRate;

    switch (type) {
      case "short":
        this.duration = 3;
        break;
      case "medium":
        this.duration = 6;
        break;
      case "long":
        this.duration = 12;
        break;
      default:
        this.duration = 0;
        break;
    }
  }

  public double executeInvestment() {
    double volatility =
        switch (risk) {
          case "low" -> 0.02;
          case "medium" -> 0.05;
          case "high" -> 0.1;
          default -> 0.0;
        };

    Random rand = new Random();
    double randomFactor = rand.nextDouble() * 2 - 1;

    double actualReturnRate = returnRate + randomFactor * volatility;

    return amount * (1 + actualReturnRate);
  }

  public String getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }

  public int getDuration() {
    return duration;
  }

  public String getRisk() {
    return risk;
  }

  public double getReturnRate() {
    return returnRate;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }
}
