package main.model;

public class Loan {
    private double amount;
    private String description;
    private double interestRate;


    public Loan(double amount, String description, double interestRate) {
        this.amount = amount;
        this.description = description;
        this.interestRate = interestRate;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public double getinterestRate() {
        return interestRate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setinterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
