import java.util.*;
class Savings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of savings per month: ");
        int savings = sc.nextInt();
        System.out.println("Enter how many months of savings: ");
        int months = sc.nextInt();
        int month = 1;
        float TotalSavings = 0;
        while(month <= months){
            TotalSavings += savings;
            System.out.println("Month " + month + ": " + TotalSavings);
            month++;
            
        }
        System.out.println("The total savings amount is: " +(savings*month));
    }
}
