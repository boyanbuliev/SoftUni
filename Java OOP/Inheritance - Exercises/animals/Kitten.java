package animals;

public class Kitten extends Cat {
    private static final String GENDER= "Female";

    public Kitten(String name, int age) {
        this(name, age, GENDER);
    }

    public Kitten(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
