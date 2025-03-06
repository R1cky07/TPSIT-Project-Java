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
    }

    public double executeInvestment() {
        return 0;
    }

}