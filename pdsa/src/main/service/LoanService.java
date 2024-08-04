package main.service;
import main.model.Loan;

import java.util.LinkedList;

public class LoanService {
    private LinkedList<Loan> loans;

    public LoanService() {
        this.loans = new LinkedList<>();
    }

    public void addLoans(double amount, String description,double interestRate) {
        Loan loan = new Loan(amount, description, interestRate);
        loans.add(loan);
    }

    public void printAllLoans() {
        for (Loan loan : loans) {
            System.out.println("Description: " + loan.getDescription() + "  " + ", Amount: " + loan.getAmount());
        }
    }
    public void calculateInterest(){
        double interestAmount = 0;
        double totalDue = 0;
        double totalLoans = 0;
        for(Loan loan : loans){
            interestAmount = loan.getAmount() * loan.getinterestRate()/100;
            totalDue = loan.getAmount() + interestAmount;
            totalLoans += totalDue;
            System.out.println(loan.getDescription() + "  "+ "Interest Amount : " + interestAmount + "  " + "Total Due Amount : " + totalDue);
        }
        System.out.println("Total Loans : " + totalLoans);
    }
}
