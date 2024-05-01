import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SchoolTest {
    public static void main(String[] args) {
        // Create an instance of the 'School' class
        School school = new School();

        // Add teachers and subjects
        Teacher mathTeacher = new Teacher(1, "Math Teacher", 2000);
        Teacher chemistryTeacher = new Teacher(2, "Chemistry Teacher", 2300);
        Teacher italianTeacher = new Teacher(3, "Italian Teacher", 1900);
        Teacher biologyTeacher = new Teacher(4, "Biology Teacher", 2150);

        school.addTeacher(mathTeacher);
        school.addTeacher(chemistryTeacher);
        school.addTeacher(italianTeacher);
        school.addTeacher(biologyTeacher);

        Subject mathSubject = new Subject(101, "Mathematics", mathTeacher);
        Subject chemistrySubject = new Subject(102, "Chemistry", chemistryTeacher);
        Subject italianSubject = new Subject(103, "Italian", italianTeacher);
        Subject biologySubject = new Subject(104, "Biology", biologyTeacher);

        // Add students to subjects and school
        Student student1 = new Student(1001, "Sara");
        Student student2 = new Student(1002, "Anne");
        Student student3 = new Student(1003, "John");
        Student student4 = new Student(1004, "David");

        mathSubject.getStudentList().add(student1);
        mathSubject.getStudentList().add(student2);
        chemistrySubject.getStudentList().add(student3);
        italianSubject.getStudentList().add(student4);
        biologySubject.getStudentList().add(student2);

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        school.addStudent(student4);

        // Perform fee payments
        school.getStudents().get(0).payFee(2000);
        school.getStudents().get(1).payFee(3000);
        school.getStudents().get(2).payFee(2500);
        school.getStudents().get(3).payFee(5000);

        // Calculate total money earned and spent
        for (Student student : school.getStudents()) {
            school.totalMoneyEarned += student.getFeesPaid();
        }

        for (Teacher teacher : school.getTeachers()) {
            school.totalMoneySpent += teacher.getSalary();
        }

        // Calculate net earnings/losses
        double netEarnings = school.totalMoneyEarned - school.totalMoneySpent;

        // Display financial info
        System.out.println("Total Money Earned: $" + school.totalMoneyEarned);
        System.out.println("Total Money Spent on Teachers' Salary: $" + school.totalMoneySpent);
        System.out.println("Net Earnings/Losses: $" + netEarnings);

        // Save student fees to student.txt
        saveStudentFeesToFile("student.txt", school.getStudents());

    }

    // Create a private method that takes a filename and a list of students. Write their info to a text file.
    private static void saveStudentFeesToFile(String filename, List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Sort students alphabetically
            Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));

            // Write student information to the file
            for (Student student : students) {
                writer.write("Student ID: " + student.getId() + ", Name: " + student.getName() +
                        ", Fees Paid: $" + student.getFeesPaid());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}