package main.service;

import main.model.TransactionNode;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private TransactionNode head;

    public TransactionService() {
        this.head = null;
    }

    public void addTransaction(String type, double amount, String description) {
        TransactionNode newNode = new TransactionNode(type, amount, description);
        if (head == null) {
            head = newNode;
        } else {
            TransactionNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void updateTransaction(TransactionNode transaction, double newAmount, String newDescription) {
        transaction.setAmount(newAmount);
        transaction.setDescription(newDescription);
    }

    public void deleteTransaction(TransactionNode transaction) {
        if (head == transaction) {
            head = head.getNext();
        } else {
            TransactionNode current = head;
            while (current != null && current.getNext() != transaction) {
                current = current.getNext();
            }
            if (current != null) {
                current.setNext(transaction.getNext());
            }
        }
    }

    public List<TransactionNode> getTransactionsByType(String type) {
        List<TransactionNode> transactions = new ArrayList<>();
        TransactionNode current = head;
        while (current != null) {
            if (current.getType().equalsIgnoreCase(type)) {
                transactions.add(current);
            }
            current = current.getNext();
        }
        return transactions;
    }

    public void printAllTransactions() {
        System.out.println("Incomes:");
        TransactionNode current = head;
        while (current != null) {
            if (current.getType().equalsIgnoreCase("income")) {
                System.out.println("Description: " + current.getDescription() + ", Amount: " + current.getAmount());
            }
            current = current.getNext();
        }

        System.out.println("\nExpenses:");
        current = head;
        while (current != null) {
            if (current.getType().equalsIgnoreCase("expense")) {
                System.out.println("Description: " + current.getDescription() + ", Amount: " + current.getAmount());
            }
            current = current.getNext();
        }
    }

    public void printSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        TransactionNode current = head;
        while (current != null) {
            if (current.getType().equalsIgnoreCase("income")) {
                totalIncome += current.getAmount();
            } else if (current.getType().equalsIgnoreCase("expense")) {
                totalExpense += current.getAmount();
            }
            current = current.getNext();
        }

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Balance: " + (totalIncome - totalExpense));
    }
}
