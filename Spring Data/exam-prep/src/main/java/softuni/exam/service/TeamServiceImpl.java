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
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
            if (validatorUtil.isValid(t) && teamRepository.findByName(t.getName()) == null
                    && pictureService.getByUrl(t.getPicture().getUrl()) != null) {
                Team team = modelMapper.map(t, Team.class);
                team.setPicture(pictureService.getByUrl(t.getPicture().getUrl()));
                teamRepository.save(team);
                sb.append(String.format("Successfully imported team - %s", t.getName()));
            } else {
                sb.append("Invalid team");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() != 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
      return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.findByName(name);
    }

}
