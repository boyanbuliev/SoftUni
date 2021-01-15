package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedDto;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constants.GlobalConstants.TEAMS_FILE_PATH;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final PictureService pictureService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public TeamServiceImpl(TeamRepository teamRepository, PictureService pictureService, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.teamRepository = teamRepository;
        this.pictureService = pictureService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        List<TeamSeedDto> teams = xmlParser.unmarshalFromFile(TEAMS_FILE_PATH, TeamSeedRootDto.class).getTeams();
        teams.forEach(t -> {
            if (validatorUtil.isValid(t)) {
                if (teamRepository.findByName(t.getName()) == null && pictureService.getByUrl(t.getPicture().getUrl()) != null) {
                    Team team = new Team();
                    team.setName(t.getName());
                    team.setPicture(pictureService.getByUrl(t.getPicture().getUrl()));
                    teamRepository.save(team);
                    sb.append(String.format("Successfully imported team - %s%n", t.getName()));
                } else {
                    sb.append("Invalid team").append(System.lineSeparator());
                }
            } else {
                validatorUtil.violations(t).stream().map(ConstraintViolation::getMessage)
                        .forEach(v -> sb.append(String.format("%s%n", v)));

            }
        });
        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count()!=0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
      return String.join("\n", Files.readAllLines(Path.of("src/main/resources/files/xml/teams.xml")));
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

}
