import entities.gringotts.WizardDeposit;

import javax.persistence.EntityManager;

public class Engine implements Runnable {
    private final EntityManager em;

    public Engine(EntityManager em) {
        this.em = em;
    }

    @Override
    public void run() {
        WizardDeposit wd = new WizardDeposit();
        wd.setLastName("Pesho");
        wd.setAge(10);

        this.em.getTransaction().begin();
        this.em.persist(wd);
        this.em.getTransaction().commit();
    }
}
