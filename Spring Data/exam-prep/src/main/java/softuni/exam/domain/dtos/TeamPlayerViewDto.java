package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class TeamPlayerViewDto {
    @Expose
    private String name;
    @Expose
    private List<PlayerFromTeamViewDto> players;

    public TeamPlayerViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerFromTeamViewDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerFromTeamViewDto> players) {
        this.players = players;
    }
}
