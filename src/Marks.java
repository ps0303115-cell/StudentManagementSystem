public class Marks {
    private int studentId;
    private double javaMarks;
    private double mathsMarks;
    private double dbmsMarks;
    public Marks(int studentId, double javaMarks, double mathsMarks, double dbmsMarks) {
        this.studentId = studentId;
        this.javaMarks = javaMarks;
        this.mathsMarks = mathsMarks;
        this.dbmsMarks = dbmsMarks;
    }
    public int getStudentId() {
        return studentId;
    }
    public double getJavaMarks() {
        return javaMarks;
    }
    public double getMathsMarks() {
        return mathsMarks;
    }
    public double getDbmsMarks() {
        return dbmsMarks;
    }
    public double calculatePercentage() {
        return (javaMarks + mathsMarks + dbmsMarks) / 3;
    }
    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}