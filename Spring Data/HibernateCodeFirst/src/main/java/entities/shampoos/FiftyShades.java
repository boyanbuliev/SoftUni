package entities.shampoos;

import entities.labels.BasicLabel;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FiftyShades extends BasicShampoo{
    public FiftyShades() {
        super("Fifty Shades",new BigDecimal(6.69),Size.SMALL, new BasicLabel("Fifty Shades",
                "It’s made of Strawberry and Nettle"));
    }
}
