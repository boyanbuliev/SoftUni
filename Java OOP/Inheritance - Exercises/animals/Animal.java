package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalStateException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (name.trim().isEmpty()) {
            throw new IllegalStateException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {

        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(), this.name, this.age, this.gender, produceSound());
    }

    public String getClassName() {
        return this.getClass().getSimpleName().toString();
    }

    public abstract String produceSound();
}
