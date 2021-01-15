package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.domain.entities.Position;

import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PlayerSeedDto {
    @Expose
    @NotNull
    private String firstName;
    @Expose
    @NotNull
    @Length(min = 3, max = 15)
    private String lastName;
    @Expose
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer number;
    @Expose
    @NotNull
    @Min(value = 0)
    private BigDecimal salary;
    @Expose
    @NotNull
    @Enumerated
    private Position position;
    @NotNull
    @Expose
    private PictureSeedDto picture;
    @Expose
    private TeamSeedDto team;

    public PlayerSeedDto() {
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

    public PictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedDto picture) {
        this.picture = picture;
    }

    public TeamSeedDto getTeam() {
        return team;
    }

    public void setTeam(TeamSeedDto team) {
        this.team = team;
    }
}
