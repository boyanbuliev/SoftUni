package entities.shampoos;

import entities.labels.BasicLabel;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FreshNuke extends BasicShampoo{
    public FreshNuke() {
        super("Fresh Nuke",new BigDecimal(9.33),Size.BIG, new BasicLabel("Fresh Nuke",
                "It’s made of Mint, Nettle and Ammonium Chloride"));
    }
}
