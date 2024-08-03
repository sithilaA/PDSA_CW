
// ---------------- Akalanka

package main.model;

import java.util.Scanner;

public class SavingGoalsAndProgress {
    double saving_goal_01 ;
    double saving_goal_02 ;
    double saving_goal_03 ;
   public void create_Saving_Goals(Scanner scanner){
        System.out.println("You can set three financial goals here. If you have only two goals, set the first to zero and use the remaining two, If you have only one goals, set the first two zero and use the remaining one.");
        System.out.println("Input Your Savings Goal 01");
        saving_goal_01 = scanner.nextDouble();

        System.out.println("Input Your Savings Goal 02");
        saving_goal_02 = scanner.nextDouble();

        System.out.println("Input Your Savings Goal 03");
        saving_goal_03 = scanner.nextDouble();

        if ( saving_goal_03>0 ){
            System.out.println("Saving goal has been saved successfully.");
        }
    }
    public void track_progress(double total_expenses,double total_income){
        double totale_Saving = total_income - total_expenses ;
        if (saving_goal_03>0 ){
            if(totale_Saving > saving_goal_01 && totale_Saving < saving_goal_02 && totale_Saving < saving_goal_03){
                System.out.println("You achieved your first saving goal");
            }
            else if( totale_Saving > saving_goal_02 && totale_Saving < saving_goal_03){
                System.out.println("You achieved your second saving goal.");
            }
            else if(totale_Saving > saving_goal_03 ){
                System.out.println("You achieved your third saving goal.");
            }
            else {
                System.out.println("You have not achieved your saving goal.");
            }
        }
        else{
            System.out.println("Please enter your saving goals.");

        }
    }
}
