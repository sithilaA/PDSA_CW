package main.service;

import main.model.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionService {
    private List<Transaction> transactions;

    public TransactionService() {
        this.transactions = new LinkedList<>();
    }

    public void addTransaction(String type, double amount, String description, String category) {
        Transaction transaction = new Transaction(type, amount, description, category);
        transactions.add(transaction);
    }

    public void updateTransaction(Transaction transaction, double newAmount, String newDescription, String newCategory) {
        transaction.setAmount(newAmount);
        transaction.setDescription(newDescription);
        transaction.setCategory(newCategory);
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
                System.out.println("Description: " + transaction.getDescription() + ", Amount: " + transaction.getAmount() + ", Category: " + transaction.getCategory());
            }
        }

        System.out.println("\nExpenses:");
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("expense")) {
                System.out.println("Description: " + transaction.getDescription() + ", Amount: " + transaction.getAmount() + ", Category: " + transaction.getCategory());
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

    public double totalIncome(){
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("income")) {
                totalIncome += transaction.getAmount();
            }
        }
        return totalIncome;
    }
    public double totalExpense(){
        double totalExpense = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("expense")) {
                totalExpense += transaction.getAmount();
            }
        }
        return totalExpense;
    }

    public void addIncome() {
        double totIncome = 0;
        for (Transaction transaction : transactions) {
            totIncome += transaction.getAmount();
        }
    }

    public void expenseAndBudgetTracker(){
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
        System.out.println("Difference: " + (totalIncome-totalExpense));
        if (totalExpense <= totalIncome - (totalIncome * 0.4)) {
            System.out.println("You are well within budget");
        } else if(totalExpense <= totalIncome - (totalIncome * 0.2)){
            System.out.println("Budget to Income gap is low");
        } else if(totalExpense <= 0){
            System.out.println("Warning!");
        } else {
            System.out.println("You are over budget!!");
        }
    }

    public void taxCalculation() {
        double totIncome = 0;
        for (Transaction transaction : transactions) {
            totIncome += transaction.getAmount();
        }

        double monthlyTaxAmount;
        double annualTaxAmount;
        double annualIncome = totIncome * 12;

        if (annualIncome < 500000) {
            System.out.println("No Tax Payment");
            annualTaxAmount = 0;  // No tax for income below 500,000 LKR
            monthlyTaxAmount = 0;
        } else if (annualIncome <= 600000) {
            annualTaxAmount = (annualIncome - 80000) * 0.08;  // 8% tax rate for income from 500,001 to 600,000
            monthlyTaxAmount = annualTaxAmount / 12;
        } else if (annualIncome <= 800000) {
            annualTaxAmount = 10000 + (annualIncome - 120000) * 0.12;  // 12% tax rate for income from 600,001 to 800,000
            monthlyTaxAmount = annualTaxAmount / 12;
        } else if (annualIncome <= 1000000) {
            annualTaxAmount = 10000 + 40000 + (annualIncome - 800000) * 0.18;  // 18% tax rate for income from 800,001 to 1,000,000
            monthlyTaxAmount = annualTaxAmount / 12;
        } else {
            annualTaxAmount = 10000 + 40000 + 60000 + (annualIncome - 1000000) * 0.24;  // 24% tax rate for income above 1,000,000
            monthlyTaxAmount = annualTaxAmount / 12;
        }

        System.out.println("Annual income: LKR " + annualIncome + "\n" + "Annual Tax Amount :" + annualTaxAmount);
        System.out.println("Monthly income: LKR " + totIncome + "\n" + "Monthly Tax Amount :" + monthlyTaxAmount);
    }
}
