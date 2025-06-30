import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ?" + amount);
            System.out.println("? Amount Deposited Successfully.");
        } else {
            System.out.println("? Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ?" + amount);
            System.out.println("? Amount Withdrawn Successfully.");
        } else {
            System.out.println("? Insufficient balance or invalid amount.");
        }
    }

    public void getBalance() {
        System.out.println("?? Current Balance: ?" + balance);
    }

    public void printTransactionHistory() {
        System.out.println("?? Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        }
    }
}

public class BankSimulationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();

        BankAccount account = new BankAccount(accountNumber, accountHolder);

        int choice;
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ?");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ?");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.getBalance();
                    break;

                case 4:
                    account.printTransactionHistory();
                    break;

                case 5:
                    System.out.println("?? Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("? Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
