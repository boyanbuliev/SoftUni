package softuni.exam.domain.dtos;

import java.util.List;

public class TeamPlayerViewDto {
    private String name;
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
