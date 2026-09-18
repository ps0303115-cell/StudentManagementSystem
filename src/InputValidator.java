public class InputValidator {
    public static boolean isValidMarks(double marks) {
        return marks >= 0 && marks <= 100;
    }
    public static boolean isValidSemester(int semester) {
        return semester >= 1 && semester <= 8;
    }
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
    public static boolean isValidBranch(String branch) {
        return branch != null && !branch.trim().isEmpty();
    }
}