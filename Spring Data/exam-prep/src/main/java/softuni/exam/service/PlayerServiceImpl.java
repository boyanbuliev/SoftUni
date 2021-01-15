package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerFromTeamViewDto;
import softuni.exam.domain.dtos.PlayerSeedDto;
import softuni.exam.domain.dtos.PlayerViewDto;
import softuni.exam.domain.dtos.TeamPlayerViewDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

import static softuni.exam.constants.GlobalConstants.PLAYERS_FILE_PATH;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PictureService pictureService;
    private final TeamService teamService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public PlayerServiceImpl(PlayerRepository playerRepository, PictureService pictureService, TeamService teamService, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.playerRepository = playerRepository;
        this.pictureService = pictureService;
        this.teamService = teamService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public String importPlayers() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        PlayerSeedDto[] playerSeedDtos = gson.fromJson(new FileReader(PLAYERS_FILE_PATH), PlayerSeedDto[].class);
        Arrays.stream(playerSeedDtos).forEach(p -> {
            if (validatorUtil.isValid(p)) {
                if (playerRepository.findByFirstNameAndLastName(p.getFirstName(), p.getLastName()) == null &&
                        teamService.getTeamByName(p.getTeam().getName()) != null &&
                        pictureService.getByUrl(p.getPicture().getUrl()) != null) {
                    Player player = modelMapper.map(p, Player.class);
                    player.setPicture(pictureService.getByUrl(p.getPicture().getUrl()));
                    player.setTeam(teamService.getTeamByName(p.getTeam().getName()));
                    playerRepository.save(player);
                    sb.append(String.format("Successfully imported player - %s %s%n",
                            p.getFirstName(), p.getLastName()));
                } else {
                    sb.append("Invalid player").append(System.lineSeparator());
                }
            } else {
                validatorUtil.violations(p).stream().map(ConstraintViolation::getMessage)
                        .forEach(v -> sb.append(v).append(System.lineSeparator()));
            }
        });
        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() != 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();
        playerRepository.findAllBySalaryGreaterThan(BigDecimal.valueOf(100000)).stream()
                .map(p -> modelMapper.map(p, PlayerViewDto.class))
                .forEach(p -> sb.append(
                        String.format("Player name: %s %s%n\tNumber: %d%n\tSalary: %.2f%n\tTeam: %s%n",
                                p.getFirstName(), p.getLastName(), p.getNumber(),
                                p.getSalary(), p.getTeam().getName())));
        return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();
        TeamPlayerViewDto team = new TeamPlayerViewDto();
        team.setName("North Hub");
        team.setPlayers(playerRepository.findAllByTeamOrderById("North Hub").stream()
                .map(p -> modelMapper.map(p, PlayerFromTeamViewDto.class)).collect(Collectors.toList()));
        sb.append(String.format("Team: %s%n", team.getName()));
        team.getPlayers().forEach(p -> sb.append(String.format(
                "\tPlayer name: %s %s - %s%n", p.getFirstName(), p.getLastName(), p.getPosition())));
        return sb.toString();
    }
}
