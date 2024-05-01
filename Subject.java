import java.util.ArrayList;
import java.util.List;

class Subject {
    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> studentList;

    // Constructor to initialize a Subject object
    //  studentList is automatically initialized as an empty list
    public Subject(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.studentList = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

}