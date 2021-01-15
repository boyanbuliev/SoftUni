package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class PlayerViewDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer number;
    @Expose
    private BigDecimal salary;
    @Expose
    private TeamViewDto team;

    public PlayerViewDto() {
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

    public TeamViewDto getTeam() {
        return team;
    }

    public void setTeam(TeamViewDto team) {
        this.team = team;
    }
}
