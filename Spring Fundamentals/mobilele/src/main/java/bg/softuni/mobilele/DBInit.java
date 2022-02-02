package bg.softuni.mobilele;

import bg.softuni.mobilele.model.entities.BaseEntity;
import bg.softuni.mobilele.model.entities.BrandEntity;
import bg.softuni.mobilele.model.entities.ModelEntity;
import bg.softuni.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.model.entities.enums.EngineEnum;
import bg.softuni.mobilele.model.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilele.model.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;

    public DBInit(ModelRepository modelRepository, BrandRepository brandRepository, OfferRepository offerRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750s(hondaBrand);
        createFiestaOffer(fiestaModel);
    }

    private void createFiestaOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(EngineEnum.GASOLINE)
                .setImageUrl("https://www.motopfohe.bg/files/news/archive/2017/08/blob-server.jpg")
                .setMileage(40000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("Karana e ot nemska baba. Zimata v garaj.")
                .setTransmission(TransmissionEnum.MANUAL)
                .setModel(modelEntity);
        setCurrentTimestamps(fiestaOffer);
        offerRepository.save(fiestaOffer);
    }

    private ModelEntity initNC750s(BrandEntity brandEntity) {
        ModelEntity nc750s = new ModelEntity();
        nc750s.setName("NC750S").setCategory(ModelCategoryEnum.MOTORCYCLE)
                .setBrand(brandEntity)
                .setImageUrl("https://www.webike-china.cn/images/mybike/485/18485_10227_L.jpg")
                .setStartYear(2014);
        setCurrentTimestamps(nc750s);
        return modelRepository.save(nc750s);
    }

    private ModelEntity initEscort(BrandEntity brandEntity) {
        ModelEntity escort = new ModelEntity();
        escort.setName("Escort").setCategory(ModelCategoryEnum.CAR)
                .setBrand(brandEntity)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/Ford_Escort_MkI_1100_1972.JPG")
                .setStartYear(1968)
                .setEndYear(2002);
        setCurrentTimestamps(escort);
        return modelRepository.save(escort);
    }

    private ModelEntity initFiesta(BrandEntity brandEntity) {
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta").setCategory(ModelCategoryEnum.CAR)
                .setBrand(brandEntity)
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setStartYear(1976);
        setCurrentTimestamps(fiesta);
        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now())
                .setUpdated(Instant.now());
    }
}
