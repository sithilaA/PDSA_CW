package main;

import main.service.TransactionService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionService transactionService = new TransactionService();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter income amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter description:");
                String description = scanner.nextLine();
                transactionService.addTransaction("income", amount, description);
            } else if (choice == 2) {
                System.out.println("Enter expense amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter description:");
                String description = scanner.nextLine();
                transactionService.addTransaction("expense", amount, description);
            } else if (choice == 3) {
                transactionService.printTransactions();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}