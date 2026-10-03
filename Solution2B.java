import java.util.*;
public class Solution2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the energy generated in (kWh) is?");
        float energy = sc.nextFloat();
        if ( energy >= 10) 
        {
            System.out.println("Good Energy Generation");
        } 
        else 
        {
            System.out.println("ELow Energy Generation");
        }
    }
}
