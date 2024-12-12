// Student class
class Student {
    private int id;
    private String name;
    private String grade;

    // Constructor
    public Student(int id, String name,String grade) {
        this.id = id;
        this.name = name;
        this .grade = grade;
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String name) {
        this.grade = name;
    }
}