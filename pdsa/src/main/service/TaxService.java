package main.service;

import main.model.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TaxService {
    private List<Transaction> tax;



    public void taxCalculation() {
        double totIncome = 0;
        for (Transaction tax : tax) {
            totIncome += tax.getAmount();
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
