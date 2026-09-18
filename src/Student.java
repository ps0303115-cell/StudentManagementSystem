public class Student {
    private int studentId;
    private String name;
    private String branch;
    private int semester;
    public Student(int studentId, String name, String branch, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public String getBranch() {
        return branch;
    }
    public int getSemester() {
        return semester;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Branch     : " + branch);
        System.out.println("Semester   : " + semester);
    }
}