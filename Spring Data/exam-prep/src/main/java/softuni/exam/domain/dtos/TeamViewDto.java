package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;

public class TeamViewDto {
    @Expose
    private String name;

    public TeamViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
