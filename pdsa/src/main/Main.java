package main;

import main.service.LoanService;
import main.model.Loan;
import main.service.TransactionService;
import main.model.Transaction;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionService transactionService = new TransactionService();
        LoanService loanService = new LoanService();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Incomes and Expenses");
            System.out.println("2. View Transactions and Summary");
            System.out.println("3. Update a Transaction");
            System.out.println("4. Delete a Transaction");
            System.out.println("5. Tax calculation");
            System.out.println("6. Loans");
            System.out.println("7. Create Saving Goals");
            System.out.println("8. Track Progress");
            System.out.println("9. Exit");

            int choice = getValidChoice(scanner, 5);

            if (choice == 1) {
                addIncomesAndExpenses(scanner, transactionService);
            } else if (choice == 2) {
                viewTransactionsAndSummary(scanner, transactionService);
            } else if (choice == 3) {
                updateTransaction(scanner, transactionService);
            } else if (choice == 4) {
                deleteTransaction(scanner, transactionService);
            } else if (choice == 5) {
                TaxCalculation(transactionService);
            }else if (choice == 6){
                LoanMan(scanner, loanService);
            } else if (choice == 7) {
                System.out.println("7 Select");
            } else if (choice == 8) {
                System.out.println("8 Select");
            } else if(choice == 9) {
                break;
            }
        }

        scanner.close();
    }

    private static int getValidChoice(Scanner scanner, int maxOption) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= maxOption) {
                    break;
                } else {
                    System.out.println("Invalid choice, please try again.");
                }
            } else {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static void addIncomesAndExpenses(Scanner scanner, TransactionService transactionService) {
        while (true) {
            System.out.println("Enter income amount (0 to finish, -1 to go back):");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount == -1) {
                return;
            } else if (amount == 0) {
                break;
            }
            System.out.println("Enter income description:");
            String description = scanner.nextLine();
            transactionService.addTransaction("income", amount, description);
        }

        while (true) {
            System.out.println("Enter expense amount (0 to finish, -1 to go back):");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount == -1) {
                return;
            } else if (amount == 0) {
                break;
            }
            System.out.println("Enter expense description:");
            String description = scanner.nextLine();
            transactionService.addTransaction("expense", amount, description);
        }
    }

    private static void viewTransactionsAndSummary(Scanner scanner, TransactionService transactionService) {
        transactionService.printSummary();
        while (true) {
            System.out.println("Do you want to view detailed transactions? (y/n, home to go back)");
            String viewDetails = scanner.nextLine();
            if (viewDetails.equalsIgnoreCase("home")) {
                return;
            } else if (viewDetails.equalsIgnoreCase("y")) {
                transactionService.printAllTransactions();
                return;
            } else if (viewDetails.equalsIgnoreCase("n")) {
                return;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void updateTransaction(Scanner scanner, TransactionService transactionService) {
        while (true) {
            System.out.println("Choose the type to update (income/expense, home to go back):");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("home")) {
                return;
            } else if (type.equalsIgnoreCase("income") || type.equalsIgnoreCase("expense")) {
                List<Transaction> transactions = transactionService.getTransactionsByType(type);
                if (transactions.isEmpty()) {
                    System.out.println("No transactions found.");
                    return;
                }
                System.out.println("Select the transaction to update:");
                for (int i = 0; i < transactions.size(); i++) {
                    Transaction transaction = transactions.get(i);
                    System.out.println((i + 1) + ". Description: " + transaction.getDescription() + ", Amount: " + transaction.getAmount());
                }
                int index = getValidChoice(scanner, transactions.size()) - 1;
                System.out.println("Enter the new amount:");
                double newAmount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter the new description:");
                String newDescription = scanner.nextLine();
                transactionService.updateTransaction(transactions.get(index), newAmount, newDescription);
                return;
            } else {
                System.out.println("Invalid type, please try again.");
            }
        }
    }

    private static void deleteTransaction(Scanner scanner, TransactionService transactionService) {
        while (true) {
            System.out.println("Choose the type to delete (income/expense, home to go back):");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("home")) {
                return;
            } else if (type.equalsIgnoreCase("income") || type.equalsIgnoreCase("expense")) {
                List<Transaction> transactions = transactionService.getTransactionsByType(type);
                if (transactions.isEmpty()) {
                    System.out.println("No transactions found.");
                    return;
                }
                System.out.println("Select the transaction to delete:");
                for (int i = 0; i < transactions.size(); i++) {
                    Transaction transaction = transactions.get(i);
                    System.out.println((i + 1) + ". Description: " + transaction.getDescription() + ", Amount: " + transaction.getAmount());
                }
                int index = getValidChoice(scanner, transactions.size()) - 1;
                transactionService.deleteTransaction(transactions.get(index));
                return;
            } else {
                System.out.println("Invalid type, please try again.");
            }
        }
    }

    private static void TaxCalculation(TransactionService transactionService){
        transactionService.addIncome();
    }

    private static void LoanMan(Scanner scanner, LoanService loanService){
        while (true) {
            System.out.println("Enter loan amount (0 to finish, -1 to go back):");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount == -1)
                return;

            if(amount == 0){
                break;
            }
            System.out.println("Enter loan description:");
            String description = scanner.nextLine();
            loanService.addLoans(amount, description);
            //loanService.printAllLoans();
        }
        loanService.printAllLoans();
    }

    /*private static void addIncomesAndExpenses(Scanner scanner, TransactionService transactionService) {
        while (true) {
            System.out.println("Enter income amount (0 to finish, -1 to go back):");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount == -1) {
                return;
            } else if (amount == 0) {
                break;
            }
            System.out.println("Enter income description:");
            String description = scanner.nextLine();
            transactionService.addTransaction("income", amount, description);
        }

        while (true) {
            System.out.println("Enter expense amount (0 to finish, -1 to go back):");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount == -1) {
                return;
            } else if (amount == 0) {
                break;
            }
            System.out.println("Enter expense description:");
            String description = scanner.nextLine();
            transactionService.addTransaction("expense", amount, description);
        }*/
}
