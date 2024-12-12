import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        StudentRecordManagement srm = StudentRecordManagement.getInstance();
        srm.deletFile();
        Scanner scanner = new Scanner(System.in);




        while (true) {
            System.out.println("=================Please chose One from below=================================");

            System.out.println("1.  Lägg till nya studentposter.");
            System.out.println("2.  Sök efter en student via deras ID.");
            System.out.println("3.  Visa alla sparade studenter.");
            System.out.println("4.  Spara studentposter till fil.");
            System.out.println("5.  Läs studentposter från fil och visa dem i systemet.");
            System.out.println("6.  Avsluta programmet.");
            System.out.println("Your Choice= ");


            int choice = scanner.nextInt();
             String fileName = "studentData.txt";
            if (choice == 1) {
                System.out.println("please enter student id:");
                int id = scanner.nextInt();
                System.out.println("Enter student name:");
                String name = scanner.next();
                System.out.println("Enter student grade");
                String grade = scanner.next();
                Student student = new Student(id,name,grade);
                srm.addStudent(student);

            } else if (choice == 2) {
                System.out.println("please enter student id:");
                int id = scanner.nextInt();
                Student student = srm.searchStudent(id);
                if(student==null){
                    System.out.println("Student not found please check if id is valid...");
                } else {
                    System.out.println("Student found with following details:");
                    printStudent(student);
                }

            } else if (choice ==3) {
                srm.displayRecords();

            } else if (choice ==4) {

                srm.saveStudentDataToFile(fileName);

            } else if (choice ==5) {

                srm.readDataFile(fileName);
            } else if (choice==6) {
                System.out.println("data is entered successfully");
                break;

            }



        }
    }
    private static void printStudent(Student student){
        System.out.println("Id: "+student.getId());
        System.out.println("Name : "+student.getName());
        System.out.println("Grade : "+student.getGrade());



    }



}


