import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final String GRINGOTTS_PU = "gringotts";
    private static final String SALES_PU = "sales";
    private static final String UNIVERSITY_SYSTEM_PU = "university_system";
    private static final String HOSPITAL_PU = "hospital";
    private static final String BILLS_PAYMENT_SYSTEM = "bills_payment_system";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(BILLS_PAYMENT_SYSTEM);
        EntityManager em = factory.createEntityManager();

        Engine engine = new Engine(em);
        engine.run();


    }
}
