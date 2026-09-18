import java.util.Scanner;
public class Menu {
    private Scanner scanner;
    public Menu() {
        scanner = new Scanner(System.in);
    }
    public int showMenu() {
        System.out.println("\n====================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Add Marks");
        System.out.println("6. Display Marks");
        System.out.println("7. Generate Student Report");
        System.out.println("8. Save Data");
        System.out.println("9. Exit");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
    public Scanner getScanner() {
        return scanner;
    }
}