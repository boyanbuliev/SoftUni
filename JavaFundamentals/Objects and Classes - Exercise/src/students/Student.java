package students;

public class Student {
    private String firstName;
    private String lastName;
    private String grade;

    public Student(String firstName, String lastName, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getGrade() {
        return this.grade;
    }

    @Override
    public String toString(){
        return String.format("%s %s: %s", this.firstName,this.lastName,this.grade);
    }
}
