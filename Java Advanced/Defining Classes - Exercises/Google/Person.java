package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemon = new ArrayList<>();
    private List<Parent> parent = new ArrayList<>();
    private List<Child> child = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public List<Parent> getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent.add(parent);
    }

    public void setChild(Child child) {
        this.child.add(child);
    }

    public List<Child> getChild() {
        return child;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        String company = this.company != null ? this.company.toString() : "";

        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append(System.lineSeparator())
                .append("Company:")
                .append(System.lineSeparator())
                .append(company)
                .append("Car:")
                .append(System.lineSeparator())
                .append(this.car != null ? this.car.toString() : "")
                .append("Pokemon:")
                .append(System.lineSeparator());
        for (Pokemon pokemon : getPokemon()) {
            sb.append(pokemon.getName() + " " + pokemon.getType())
                    .append(System.lineSeparator());
        }
        sb.append("Parents:")
                .append(System.lineSeparator());
        for (Parent parent : getParent()) {
            sb.append(parent.getName() + " " + parent.getBirthday())
                    .append(System.lineSeparator());
        }
        sb.append("Children:")
                .append(System.lineSeparator());
        for (Child child : getChild()) {
            sb.append(child.getName() + " " + child.getBirthday())
                    .append(System.lineSeparator());
        }


//                .append(this.pokemon.size() > 0 ? String.join("%n", this.) : "")
//                .append(System.lineSeparator())
//                .append("Parents:")
//                .append(System.lineSeparator())
//                .append(this.parent.size() > 0 ? String.join("%n", this.parent.toString()) : "")
//                .append(System.lineSeparator())
//                .append("Children:")
//                .append(System.lineSeparator())
//                .append(this.child.size() > 0 ? String.join("%n", this.child.toString()) : "");


        return sb.toString();
    }
}
