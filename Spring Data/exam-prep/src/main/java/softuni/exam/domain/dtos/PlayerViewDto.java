package softuni.exam.domain.dtos;

import java.math.BigDecimal;

public class PlayerViewDto {
    private String firstName;
    private String lastName;
    private Integer number;
    private BigDecimal salary;
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
