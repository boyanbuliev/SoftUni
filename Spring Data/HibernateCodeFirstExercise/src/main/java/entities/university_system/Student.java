package entities.university_system;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.Set;

public class Student extends Person {
    private double averageGrade;
    private double attendance;
    private Set<Course> courses;

    public Student() {
    }


    @Column(name = "average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Column
    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(targetEntity = Course.class, mappedBy = "students")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
