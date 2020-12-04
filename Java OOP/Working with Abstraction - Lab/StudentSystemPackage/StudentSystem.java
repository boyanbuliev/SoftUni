package StudentSystemPackage;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public void create(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        Student student = new Student(name, age, grade);
        this.repo.putIfAbsent(name, student);
    }

    public String show(String name) {
        String view = "";
        if (repo.containsKey(name)) {
            Student student = repo.get(name);
            view = String.format("%s is %s years old.", student.getName(), student.getAge());
            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice person.";
            }
        }
        return view;
    }
}
