import java.util.ArrayList;
import java.util.List;

class School {
    private List<Student> students;
    private List<Teacher> teachers;
    double totalMoneyEarned;
    double totalMoneySpent;

    // Constructor to initialize the School object
    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    // Create a method that adds a teacher in the list
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Create a method that adds a student in the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Getters
    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

}