import java.io.*;
import java.util.ArrayList;
public class FileManager {
    private static final String FILE_PATH = "data/students.txt";
    public static void saveStudents(ArrayList<Student> students) {
        try {
            File folder = new File("data");
            if (!folder.exists()) {
                folder.mkdir();
            }
            FileWriter writer = new FileWriter(FILE_PATH);
            for (Student student : students) {
                writer.write(
                    student.getStudentId() + "," +
                    student.getName() + "," +
                    student.getBranch() + "," +
                    student.getSemester() + "\n"
                );
            }
            writer.close();
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving student data.");
        }
    }
    public static void loadStudents(StudentManager manager) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String branch = data[2];
                    int semester = Integer.parseInt(data[3]);
                    Student student =
                            new Student(id, name, branch, semester);
                    manager.addStudentFromFile(student);
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error while loading student data.");
        }
    }
}