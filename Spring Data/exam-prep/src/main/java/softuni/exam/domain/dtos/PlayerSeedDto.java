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
    @NotNull(message = "Invalid player")
    private String firstName;
    @Expose
    @NotNull(message = "Invalid player")
    @Length(min = 3, max = 15, message = "Invalid player")
    private String lastName;
    @Expose
    @NotNull(message = "Invalid player")
    @Min(value = 1, message = "Invalid player")
    @Max(value = 99, message = "Invalid player")
    private Integer number;
    @Expose
    @NotNull(message = "Invalid player")
    @Min(value = 0, message = "invalid player")
    private BigDecimal salary;
    @Expose
    @NotNull(message = "Invalid player")
    @Enumerated
    private Position position;
    @NotNull(message = "Invalid player")
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
