package main.service;
import main.model.Loan;
import main.model.Transaction;

import java.util.LinkedList;
//import java.util.List;

public class LoanService {
    private LinkedList<Loan> loans;

    public LoanService() {
        this.loans = new LinkedList<>();
    }

    public void addLoans(double amount, String description) {
        Loan loan = new Loan(amount, description);
        loans.add(loan);
    }

    public void printAllLoans() {
        for (Loan loan : loans) {
            System.out.println("Description: " + loan.getDescription() + "  " + ", Amount: " + loan.getAmount());
        }
    }
}