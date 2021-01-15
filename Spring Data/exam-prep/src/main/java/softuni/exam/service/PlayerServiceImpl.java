package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerSeedDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

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
        PlayerSeedDto[] playerSeedDtos = gson.fromJson(new FileReader(PLAYERS_FILE_PATH),
                PlayerSeedDto[].class);
        Arrays.stream(playerSeedDtos).forEach(p -> {
            if (validatorUtil.isValid(p) && playerRepository.findByFirstNameAndLastName(p.getFirstName(),
                    p.getLastName()) == null &&
                    teamService.getTeamByName(p.getTeam().getName()) != null &&
                    pictureService.getByUrl(p.getPicture().getUrl()) != null) {
                Player player = modelMapper.map(p, Player.class);
                player.setPicture(pictureService.getByUrl(p.getPicture().getUrl()));
                player.setTeam(teamService.getTeamByName(p.getTeam().getName()));
                playerRepository.save(player);
                sb.append(String.format("Successfully imported player - %s %s",
                        p.getFirstName(), p.getLastName()));
            } else {
                sb.append("Invalid player");
            }
            sb.append(System.lineSeparator());
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
        playerRepository.findAllBySalaryIsGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000))
                .forEach(p -> sb.append(
                        String.format("Player name: %s %s%n\tNumber: %d%n\tSalary: %.2f%n\tTeam: %s%n",
                                p.getFirstName(), p.getLastName(), p.getNumber(),
                                p.getSalary(), p.getTeam().getName())));
        return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team: North Hub\n");
        playerRepository.findAllByTeamName("North Hub").forEach(p -> sb.append(String.format(
                "\tPlayer name: %s %s - %s%n\tNumber: %d%n", p.getFirstName(), p.getLastName(),
                p.getPosition(), p.getNumber())));
        return sb.toString();
    }
}
