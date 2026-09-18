import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        AcademicManager academicManager = new AcademicManager();
        FileManager.loadStudents(studentManager);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("====================================");
        System.out.println("  STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");
        while (running) {
            System.out.println("\n====================================");
            System.out.println("           MAIN MENU");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Marks");
            System.out.println("7. Display Marks");
            System.out.println("8. Generate Student Report");
            System.out.println("9. Save Data");
            System.out.println("10. Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Branch: ");
                    String branch = scanner.nextLine();
                    System.out.print("Enter Semester: ");
                    int semester = scanner.nextInt();
                    if (!InputValidator.isValidName(name)) {
                        System.out.println("Invalid student name.");
                        break;
                    }
                    if (!InputValidator.isValidBranch(branch)) {
                        System.out.println("Invalid branch.");
                        break;
                    }
                    if (!InputValidator.isValidSemester(semester)) {
                        System.out.println(
                                "Semester must be between 1 and 8."
                        );
                        break;
                    }
                    Student student =
                            new Student(id, name, branch, semester);
                    studentManager.addStudent(student);
                    break;
                case 2:
                    studentManager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();
                    studentManager.searchStudent(searchId);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    if (studentManager.findStudent(updateId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Branch: ");
                    String newBranch = scanner.nextLine();
                    System.out.print("Enter New Semester: ");
                    int newSemester = scanner.nextInt();
                    if (!InputValidator.isValidName(newName)) {
                        System.out.println("Invalid student name.");
                        break;
                    }
                    if (!InputValidator.isValidBranch(newBranch)) {
                        System.out.println("Invalid branch.");
                        break;
                    }
                    if (!InputValidator.isValidSemester(newSemester)) {
                        System.out.println(
                                "Semester must be between 1 and 8."
                        );
                        break;
                    }
                    studentManager.updateStudent(
                            updateId,
                            newName,
                            newBranch,
                            newSemester
                    );
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    int deleteId = scanner.nextInt();
                    studentManager.deleteStudent(deleteId);
                    break;
                case 6:
                    System.out.print("Enter Student ID: ");
                    int marksId = scanner.nextInt();
                    if (studentManager.findStudent(marksId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter Java Marks: ");
                    double javaMarks = scanner.nextDouble();
                    System.out.print("Enter Mathematics Marks: ");
                    double mathsMarks = scanner.nextDouble();
                    System.out.print("Enter DBMS Marks: ");
                    double dbmsMarks = scanner.nextDouble();
                    if (!InputValidator.isValidMarks(javaMarks)
                            || !InputValidator.isValidMarks(mathsMarks)
                            || !InputValidator.isValidMarks(dbmsMarks)) {
                        System.out.println(
                                "Marks must be between 0 and 100."
                        );
                        break;
                    }
                    Marks marks = new Marks(
                            marksId,
                            javaMarks,
                            mathsMarks,
                            dbmsMarks
                    );
                    academicManager.addMarks(marks);
                    break;
                case 7:
                    System.out.print("Enter Student ID: ");
                    int displayId = scanner.nextInt();
                    academicManager.displayMarks(displayId);
                    break;
                case 8:
                    System.out.print("Enter Student ID: ");
                    int reportId = scanner.nextInt();
                    Student reportStudent =
                            studentManager.findStudent(reportId);
                    if (reportStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    Marks reportMarks =
                            academicManager.findMarks(reportId);
                    ReportGenerator.generateReport(
                            reportStudent,
                            reportMarks
                    );
                    break;
                case 9:
                    FileManager.saveStudents(
                            studentManager.getStudents()
                    );
                    break;
                case 10:
                    FileManager.saveStudents(
                            studentManager.getStudents()
                    );
                    System.out.println(
                            "Thank you for using the Student Management System."
                    );
                    running = false;
                    break;
                default:
                    System.out.println(
                            "Invalid choice. Please select 1 to 10."
                    );
            }
        }
        scanner.close();
    }
}