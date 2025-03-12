import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client1 = new Client("John Doe");

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. View bank account balance");
            System.out.println("4. View investment portfolio");
            System.out.println("5. Add investment");
            System.out.println("6. Advance time (1 month)");
            System.out.println("7. View portfolio");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();

            System.out.println();
            switch (choice) {
                case 1: {
                    System.out.print("How much money would you like to deposit? ");
                    double amount = scanner.nextDouble();
                    client1.depositMoney(amount);
                    break;
                }
                case 2: {
                    System.out.print("How much money would you like to withdraw? ");
                    double amount = scanner.nextDouble();
                    client1.withdrawMoney(amount);
                    break;
                }
                case 3: {
                    System.out.println("Account Balance: " + client1.getAccountBalance() + "$");
                    break;
                }
                case 4: {
                    client1.displayPortfolio();
                    break;
                }
                case 5: {
                    System.out.print("Investment type (short/medium/long): ");
                    String investmentType = scanner.next();
                    System.out.print("Risk level (low/medium/high): ");
                    String risk = scanner.next();

                    double returnRate;
                    switch (risk) {
                        case "low":
                            returnRate = 0.05;
                            break;
                        case "medium":
                            returnRate = 0.1;
                            break;
                        case "high":
                            returnRate = 0.2;
                            break;
                        default:
                            System.out.println("Invalid risk level (set it medium)");
                            returnRate = 0.1;
                            break;
                    }

                    System.out.print("Amount to invest: ");
                    double amount = scanner.nextDouble();
                    Investment newInvestment = new Investment(investmentType, amount, risk, returnRate);
                    client1.addInvestment(newInvestment);
                    break;
                }
                case 6: {
                    System.out.println("Advanced of one month...");
                    client1.advanceTime();
                    break;
                }
                case 7: {
                    System.out.println("Portfolio: " + client1.getNonBankFunds() + "$");
                    break;
                }
                case 8: {
                    System.out.println("Goodbye!");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
            System.out.println();
        } while (choice != 8);

        scanner.close();
    }
}