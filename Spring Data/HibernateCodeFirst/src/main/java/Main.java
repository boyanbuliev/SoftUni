import entities.ingredients.AmmoniumChloride;
import entities.ingredients.BasicIngredient;
import entities.ingredients.Mint;
import entities.ingredients.Nettle;
import entities.labels.BasicLabel;
import entities.shampoos.BasicShampoo;
import entities.shampoos.FiftyShades;
import entities.shampoos.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("shampoo_company");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();

        BasicLabel label = new BasicLabel("Title", "Sub");
        BasicShampoo nuke = new FreshNuke();
        BasicShampoo shades = new FiftyShades();

        nuke.getIngredients().add(am);
        nuke.getIngredients().add(mint);

        shades.getIngredients().add(nettle);
        shades.getIngredients().add(mint);

        em.persist(nuke);
        em.persist(shades);


        em.getTransaction().commit();
    }
}
