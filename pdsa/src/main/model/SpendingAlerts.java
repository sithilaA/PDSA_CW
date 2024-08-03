
// ---------------- Akalanka
package main.model;

import java.util.Scanner;

public class SpendingAlerts {
        double spending_alert ;
    public void set_Spending_Alert(Scanner scanner){
        System.out.println("Enter your spending alert limit.");
        spending_alert = scanner.nextDouble();
        if(spending_alert > 0){
            System.out.println("Your spending alert limit has been saved !!!");
        }
    }
    public void Check_Spending_Alert(double total_expenses){
        if(total_expenses>spending_alert){
            System.out.println("You've exceeded your spending limits. ");
            System.out.println("You have exceeded your spending limit by "+(total_expenses-spending_alert));

        }
        else {
            System.out.println("You have stayed within your spending limits.");
        }
    }
}
