import java.util.*;
class Solution2C {
    void Calculation(double morningEnergy, double eveningEnergy) {
        double totalEnergy = morningEnergy + eveningEnergy;
        System.out.println("Total Energy generated in (kWh): " + totalEnergy);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the energy generated in the morning (kWh): ");
        double morningEnergy = sc.nextDouble();
        System.out.print("Enter the energy generated in the evening (kWh): ");
        double eveningEnergy = sc.nextDouble();
        Solution2C obj = new Solution2C();
        obj.Calculation(morningEnergy, eveningEnergy);
    }
}
    

