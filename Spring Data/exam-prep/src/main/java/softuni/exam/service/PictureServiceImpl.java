package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PictureSeedDto;
import softuni.exam.domain.dtos.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.constants.GlobalConstants.PICTURES_FILE_PATH;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public PictureServiceImpl(PictureRepository pictureRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importPictures() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        List<PictureSeedDto> pictures = xmlParser.unmarshalFromFile(PICTURES_FILE_PATH, PictureSeedRootDto.class).getPictures();
        pictures.forEach(p -> {
            if (validatorUtil.isValid(p)) {
                if (pictureRepository.findAllByUrl(p.getUrl()) == null) {
                    pictureRepository.save(modelMapper.map(p, Picture.class));
                    sb.append(String.format("Successfully imported picture - %s%n", p.getUrl()));
                } else {
                    System.out.println("Invalid picture");
                }
            } else {
                validatorUtil.violations(p).stream().map(ConstraintViolation::getMessage)
                        .forEach(v -> sb.append(String.format("%s%n", v)));
            }
        });
        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() != 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return String.join("\n", Files.readAllLines(Path.of("src/main/resources/files/xml/pictures.xml")));

    }

    @Override
    public Picture getByUrl(String url) {
        return this.pictureRepository.findAllByUrl(url);
    }


}
