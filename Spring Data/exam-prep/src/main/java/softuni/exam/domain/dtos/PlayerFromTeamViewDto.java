package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;
import softuni.exam.domain.entities.Position;

public class PlayerFromTeamViewDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Position position;
    @Expose
    private Number number;

    public PlayerFromTeamViewDto() {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
