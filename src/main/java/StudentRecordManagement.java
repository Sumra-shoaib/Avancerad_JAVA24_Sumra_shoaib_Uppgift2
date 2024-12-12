import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class StudentRecordManagement {
    private void StudentRecordManagement() {

        // private constructor so that no one can create object of this class.
        // object is obtained only by calling getInstance() method
    }
    private static StudentRecordManagement INSTANCE;

    public static StudentRecordManagement getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StudentRecordManagement();
        }
        return INSTANCE;
    }
    Map<Integer, Student> studentRecords;

    // Constructor to initialize the HashMap
    public StudentRecordManagement() {
        studentRecords = new HashMap<Integer, Student>();
    }


    public void addStudent(Student student) {

        if (student != null) {
            if(studentRecords.get(student.getId())!=null){
                System.out.println("This Id already exist for student");
            } else{
                studentRecords.put(student.getId(), student);
            }

        } else {
            System.out.println("Student cannot be null");
        }
    }

    public Student searchStudent(Integer id) {

            Student student = studentRecords.get(id);

          return student;
    }

    // create file
    public void saveStudentDataToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (Integer id : studentRecords.keySet()) {
                Student student = studentRecords.get(id);
                fileWriter.write("ID: " + id + ", Name: " + student.getName() + "\n");
            }
            fileWriter.close();
            System.out.println("All student data save to file: "+ fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletFile(){
        File file = new File("3");
        file.delete();
        System.out.println("heelo");
    }


    public void readDataFile(String fileName) {
        try {
            File readDataObj = new File(fileName);
            Scanner reader = new Scanner(readDataObj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public void displayRecords() {
        for (int id : studentRecords.keySet()) {
            Student student = studentRecords.get(id);
            System.out.println("ID: " + id + ", Name: " + student.getName());
        }
    }

    public void searchStudentId(int id) {
        if (studentRecords.containsKey(id)) {
            System.out.println(studentRecords.get(id));

        } else {
            System.out.println("student id is not found");
        }

    }
}
