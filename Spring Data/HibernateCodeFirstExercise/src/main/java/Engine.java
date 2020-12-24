import javax.persistence.EntityManager;

public class Engine implements Runnable {
    private final EntityManager em;

    public Engine(EntityManager em) {
        this.em = em;
    }

    @Override
    public void run() {
    }
}
