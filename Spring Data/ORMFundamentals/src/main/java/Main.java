import entities.User;
import orm.EntityManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/fsd";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException, IllegalAccessException {
        Connection connection = getConnection();

        EntityManager<User> entityManager = new EntityManager<>(connection);
        User user = new User();
        user.setUsername("88888");
        user.setPassword("MyPass34");
        user.setAge(22);
        user.setRegistrationDate(LocalDate.of(2000, 11, 1));
        entityManager.persist(user);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
    }
}
