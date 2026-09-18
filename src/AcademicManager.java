import java.util.ArrayList;
public class AcademicManager {
    private ArrayList<Marks> marksList;
    public AcademicManager() {
        marksList = new ArrayList<>();
    }
    public void addMarks(Marks marks) {
        marksList.add(marks);
        System.out.println("Marks added successfully.");
    }
    public Marks findMarks(int studentId) {
        for (Marks marks : marksList) {
            if (marks.getStudentId() == studentId) {
                return marks;
            }
        }
        return null;
    }
    public void displayMarks(int studentId) {
        Marks marks = findMarks(studentId);
        if (marks == null) {
            System.out.println("Marks not found.");
            return;
        }
        System.out.println("Java Marks       : " + marks.getJavaMarks());
        System.out.println("Mathematics Marks: " + marks.getMathsMarks());
        System.out.println("DBMS Marks       : " + marks.getDbmsMarks());
        System.out.println("Percentage       : " +
                String.format("%.2f", marks.calculatePercentage()) + "%");
        System.out.println("Grade            : " + marks.calculateGrade());
    }
    public ArrayList<Marks> getMarksList() {
        return marksList;
    }
}