import java.util.Scanner;

public class EmergencyRoomTriage
 {
    static final int MAX_PATIENTS = 10;
    static String[] patientNames = new String[MAX_PATIENTS];
    static int[] ages = new int[MAX_PATIENTS];
    static int[] heartRates = new int[MAX_PATIENTS];
    static int[] oxygenLevels = new int[MAX_PATIENTS];
    static int[] priorities = new int[MAX_PATIENTS];

    static int patientCount = 0;
    static void displayTitle() {
        System.out.println("\n==========================================");
        System.out.println("       EMERGENCY ROOM TRIAGE SYSTEM");
        System.out.println("==========================================");
    }
    static int calculatePriority(int heartRate, int oxygen, int age) 
    {
        if (oxygen < 90 || heartRate > 130 || heartRate < 40)
     {
            return 1;
        }
        else if (oxygen < 94 || heartRate > 110 || age >= 65) {
            return 2;
        }
        else {
            return 3;
        }
    }
    static String getPriorityName(int priority) {

        switch (priority) {
            case 1:
                return "EMERGENCY";
            case 2:
                return "URGENT";
            case 3:
                return "NON-URGENT";
            default:
                return "UNKNOWN";
        }
    }
    static void displayPatient(String name) {
        System.out.println("Patient Name: " + name);
    }

    static void displayPatient(String name, int age) {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
    }
    static void addPatient(Scanner sc) {

        if (patientCount >= MAX_PATIENTS) {
            System.out.println("\nPatient limit reached.");
            return;
        }

        System.out.println("\n---------- ADD PATIENT ----------");

        sc.nextLine();

        System.out.print("Enter patient name: ");
        patientNames[patientCount] = sc.nextLine();

        System.out.print("Enter age: ");
        ages[patientCount] = sc.nextInt();

        System.out.print("Enter heart rate: ");
        heartRates[patientCount] = sc.nextInt();

        System.out.print("Enter oxygen level (%): ");
        oxygenLevels[patientCount] = sc.nextInt();
        priorities[patientCount] = calculatePriority(
                heartRates[patientCount],
                oxygenLevels[patientCount],
                ages[patientCount]
        );

        System.out.println("\nPatient added successfully.");

        displayPatient(patientNames[patientCount], ages[patientCount]);

        System.out.println("Triage Priority: "
                + getPriorityName(priorities[patientCount]));

        patientCount++;
    }
    static void displayAllPatients()
     {
        if (patientCount == 0) {
            System.out.println("\nNo patients available.");
            return;
        }

        System.out.println("\n========== PATIENT LIST ==========");

        for (int i = 0; i < patientCount; i++) {

            System.out.println("\nPatient " + (i + 1));
            System.out.println("----------------------------");
            System.out.println("Name: " + patientNames[i]);
            System.out.println("Age: " + ages[i]);
            System.out.println("Heart Rate: " + heartRates[i]);
            System.out.println("Oxygen Level: " + oxygenLevels[i]);
            System.out.println("Priority: "
                    + getPriorityName(priorities[i]));
        }
    }
    static void searchPatient(Scanner sc) {

        if (patientCount == 0) {
            System.out.println("\nNo patients available.");
            return;
        }

        sc.nextLine();

        System.out.print("\nEnter patient name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < patientCount; i++) {

            if (patientNames[i].equalsIgnoreCase(searchName)) {

                System.out.println("\nPatient Found!");
                System.out.println("----------------------------");
                System.out.println("Name: " + patientNames[i]);
                System.out.println("Age: " + ages[i]);
                System.out.println("Heart Rate: " + heartRates[i]);
                System.out.println("Oxygen Level: " + oxygenLevels[i]);
                System.out.println("Priority: "
                        + getPriorityName(priorities[i]));

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nPatient not found.");
        }
    }
    static int countEmergencyPatients() {

        int count = 0;

        for (int priority : priorities) {

            if (priority == 1) {
                count++;
            }
        }

        return count;
    }
    static double calculateAverageAge() {

        if (patientCount == 0) {
            return 0;
        }

        int totalAge = 0;

        for (int i = 0; i < patientCount; i++) {
            totalAge += ages[i];
        }

        return (double) totalAge / patientCount;
    }
    static void displayStatistics() {

        if (patientCount == 0) {
            System.out.println("\nNo patient data available.");
            return;
        }

        int emergency = 0;
        int urgent = 0;
        int nonUrgent = 0;

        for (int i = 0; i < patientCount; i++) {

            if (priorities[i] == 1) {
                emergency++;
            }

            else if (priorities[i] == 2) {
                urgent++;
            }

            else {
                nonUrgent++;
            }
        }

        System.out.println("\n========== TRIAGE STATISTICS ==========");

        System.out.println("Total Patients: " + patientCount);
        System.out.println("Emergency Patients: " + emergency);
        System.out.println("Urgent Patients: " + urgent);
        System.out.println("Non-Urgent Patients: " + nonUrgent);

        System.out.println("Average Age: "
                + calculateAverageAge());
    }
    static void displayDepartmentData() {

        int[][] departmentData = {
                {10, 5, 3},
                {8, 6, 4},
                {12, 7, 2}
        };

        System.out.println("\n====== DEPARTMENT DATA ======");
        System.out.println("Rows = Days");
        System.out.println("Columns = Emergency, Urgent, Non-Urgent");

        for (int i = 0; i < departmentData.length; i++) {

            System.out.print("Day " + (i + 1) + ": ");

            for (int j = 0; j < departmentData[i].length; j++) {
                System.out.print(departmentData[i][j] + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        displayTitle();
        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Display Statistics");
            System.out.println("5. Display Department Data");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    addPatient(sc);
                    break;

                case 2:
                    displayAllPatients();
                    break;

                case 3:
                    searchPatient(sc);
                    break;

                case 4:
                    displayStatistics();
                    break;

                case 5:
                    displayDepartmentData();
                    break;

                case 6:
                    System.out.println("\nThank you for using the");
                    System.out.println("Emergency Room Triage System.");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}