package softuni.exam.domain.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    @Length(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
    private String lastName;
    @NotNull
    @Min(value = 1, message = "Number must be between 1 and 99")
    @Max(value = 99, message = "Number must be between 1 and 99")
    private Integer number;
    @NotNull
    @Min(value = 0, message = "Salary cannot be negative")
    private BigDecimal salary;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Position position;
    @NotNull
    @ManyToOne
    private Picture picture;
    @NotNull
    @ManyToOne
    private Team team;

    public Player() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
