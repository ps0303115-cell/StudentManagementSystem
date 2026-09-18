import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students;
    public StudentManager() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        if (findStudent(student.getStudentId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }
    public void addStudentFromFile(Student student) {
        students.add(student);
    }
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n----- Student List -----");
        for (Student student : students) {
            student.displayStudent();
            System.out.println("------------------------");
        }
    }
    public Student findStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
    public void searchStudent(int studentId) {
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("\nStudent found:");
            student.displayStudent();
        }
    }
    public void updateStudent(
            int studentId,
            String name,
            String branch,
            int semester) {
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.setName(name);
        student.setBranch(branch);
        student.setSemester(semester);
        System.out.println("Student updated successfully.");
    }
    public void deleteStudent(int studentId) {
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        }
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
}