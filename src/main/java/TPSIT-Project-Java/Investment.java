import java.util.Random;

public class Investment {
    private String type;
    private double amount;
    private int duration;
    private String risk;
    private double returnRate;

    public Investment(String type, double amount, String risk, double returnRate) {
        this.type = type;
        this.amount = amount;
        this.risk = risk;
        this.returnRate = returnRate;

        // Set duration based on the type of investment
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
                this.duration = 0; // Default duration if type is not recognized
                break;
        }
    }

    public double executeInvestment() {
        double volatility = 0.0;

        // Set volatility based on the risk level
        switch (risk) {
            case "low":
                volatility = 0.02;
                break;
            case "medium":
                volatility = 0.05;
                break;
            case "high":
                volatility = 0.1;
                break;
            default:
                volatility = 0.0; // Default volatility if risk is not recognized
                break;
        }

        // Generate a random factor between -1 and 1
        Random rand = new Random();
        double randomFactor = rand.nextDouble() * 2 - 1;

        // Calculate the actual return rate with volatility
        double actualReturnRate = returnRate + randomFactor * volatility;

        // Return the final amount after investment
        return amount * (1 + actualReturnRate);
    }

    // Getters for the Investment class
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

    // Setter for duration (used in advanceTime method in Client class)
    public void setDuration(int duration) {
        this.duration = duration;
    }
}