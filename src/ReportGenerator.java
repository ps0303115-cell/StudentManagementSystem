public class ReportGenerator {
    public static void generateReport(Student student, Marks marks) {
        System.out.println("\n======================================");
        System.out.println("           STUDENT REPORT");
        System.out.println("======================================");
        System.out.println("Student ID : " + student.getStudentId());
        System.out.println("Name       : " + student.getName());
        System.out.println("Branch     : " + student.getBranch());
        System.out.println("Semester   : " + student.getSemester());
        System.out.println("--------------------------------------");
        if (marks == null) {
            System.out.println("Academic records are not available.");
        } else {
            System.out.println("Java        : " + marks.getJavaMarks());
            System.out.println("Mathematics : " + marks.getMathsMarks());
            System.out.println("DBMS        : " + marks.getDbmsMarks());
            System.out.println("--------------------------------------");
            System.out.printf("Percentage  : %.2f%%%n",
                    marks.calculatePercentage());
            System.out.println("Grade       : " + marks.calculateGrade());
        }
        System.out.println("======================================");
    }
}