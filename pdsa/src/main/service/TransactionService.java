package main.service;

import main.model.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionService {
    private List<Transaction> transactions;

    public TransactionService() {
        this.transactions = new LinkedList<>();
    }

    public void addTransaction(String type, double amount, String description) {
        Transaction transaction = new Transaction(type, amount, description);
        transactions.add(transaction);
    }

    public void updateTransaction(Transaction transaction, double newAmount, String newDescription) {
        transaction.setAmount(newAmount);
        transaction.setDescription(newDescription);
    }

    public void deleteTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public List<Transaction> getTransactionsByType(String type) {
        List<Transaction> filteredTransactions = new LinkedList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase(type)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public void printAllTransactions() {
        System.out.println("Incomes:");
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                System.out.println("Description: " + transaction.getDescription() + ", Amount: " + transaction.getAmount());
            }
        }

        System.out.println("\nExpenses:");
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("expense")) {
                System.out.println("Description: " + transaction.getDescription() + ", Amount: " + transaction.getAmount());
            }
        }
    }

    public void printSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                totalIncome += transaction.getAmount();
            } else if (transaction.getType().equalsIgnoreCase("expense")) {
                totalExpense += transaction.getAmount();
            }
        }

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Balance: " + (totalIncome - totalExpense));
    }
}
