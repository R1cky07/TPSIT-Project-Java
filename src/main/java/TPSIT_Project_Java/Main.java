package TPSIT_Project_Java.TPSIT_Project_Java;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    UserManager userManager = new UserManager();
    DataPersistence dataPersistence = new DataPersistence();

    userManager.loadUsers(dataPersistence);

    while (true) {
      System.out.println("\n1. Login");
      System.out.println("2. Register");
      System.out.println("3. Exit");
      System.out.print("Choice: ");
      int choice = CheckValidFormat(scanner);

      if (choice == 1) {
        Client currentUser = userManager.authenticateUser(scanner);
        if (currentUser != null) {
          runClientMenu(currentUser, scanner, userManager, dataPersistence);
          break;
        }
      } else if (choice == 2) {
        Client newUser = userManager.registerUser(scanner);
        if (newUser != null) {
          userManager.addUser(newUser);
          userManager.saveUsers(dataPersistence);
          System.out.println("Registration successful. Please log in.");
        }
      } else if (choice == 3) {
        System.out.println("Goodbye!");
        break;
      } else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
    scanner.close();
  }

  private static void runClientMenu(
      Client currentUser,
      Scanner scanner,
      UserManager userManager,
      DataPersistence dataPersistence) {
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
      System.out.println("8. View transactions");
      System.out.println("9. Exit");
      System.out.print("Choice: ");
      choice = CheckValidFormat(scanner);

      System.out.println();
      switch (choice) {
        case 1:
          {
            System.out.print("How much money would you like to deposit? ");
            double amount = CheckValidFormat(scanner, 0);
            currentUser.depositMoney(amount);
            userManager.saveUsers(dataPersistence);
            break;
          }
        case 2:
          {
            System.out.print("How much money would you like to withdraw? ");
            double amount = CheckValidFormat(scanner, 0);
            currentUser.withdrawMoney(amount);
            userManager.saveUsers(dataPersistence);
            break;
          }
        case 3:
          {
            System.out.println("Account Balance: " + currentUser.getAccountBalance() + "$");
            break;
          }
        case 4:
          {
            currentUser.displayPortfolio();
            break;
          }
        case 5:
          {
            System.out.print("Investment type (short/medium/long): ");
            String investmentType = scanner.next();
            System.out.print("Risk level (low/medium/high): ");
            String risk = scanner.next();

            double returnRate =
                switch (risk) {
                  case "low" -> 0.05;
                  case "medium" -> 0.1;
                  case "high" -> 0.2;
                  default -> {
                    System.out.println("Invalid risk level (set it medium)");
                    yield 0.1;
                  }
                };

            System.out.print("Amount to invest: ");
            double amount = CheckValidFormat(scanner, 0);
            Investment newInvestment = new Investment(investmentType, amount, risk, returnRate);
            currentUser.addInvestment(newInvestment);
            userManager.saveUsers(dataPersistence);
            break;
          }
        case 6:
          {
            System.out.println("Advanced of one month...");
            currentUser.advanceTime();
            userManager.saveUsers(dataPersistence);
            break;
          }
        case 7:
          {
            System.out.println("Portfolio: " + currentUser.getNonBankFunds() + "$");
            break;
          }
        case 8:
          {
            currentUser.displayTransactions();
            break;
          }
        case 9:
          {
            System.out.println("Goodbye!");
            break;
          }
        default:
          {
            System.out.println("Invalid choice. Please try again.");
            break;
          }
      }
      System.out.println();
    } while (choice != 9);
  }

  private static int CheckValidFormat(Scanner scan) {
    String formatString = scan.next();
    boolean validInput = false;
    while (!validInput) {
      try {
        int choice = Integer.parseInt(formatString);
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.print("\nInvalid choice format\nPlease reinsert: ");
        formatString = scan.next();
      }
    }
    return Integer.parseInt(formatString);
  }

  private static double CheckValidFormat(Scanner scan, double amount) {
    String formatString = scan.next();
    boolean validInput = false;
    while (!validInput) {
      try {
        amount = Integer.parseInt(formatString);
        validInput = true;
      } catch (NumberFormatException e) {
        System.out.print("\nInvalid choice format\nPlease reinsert: ");
        formatString = scan.next();
      }
    }
    return Double.parseDouble(formatString);
  }
}
