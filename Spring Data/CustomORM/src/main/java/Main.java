import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Connector.createConnection("root", "1234", "custom_orm");
        Connection connection = Connector.getConnection();

        User user = new User("username2", "1234", 12, Date.valueOf("2000-01-01"));

        EntityManager<User> userManager = new EntityManager<>(connection);
//        user.setId(1);
//        userManager.persist(user);
//        user.setPassword("2345");
//        userManager.persist(user);
        User found = userManager.findFirst(User.class);
        System.out.println(found.getRegistrationDate());
        userManager.find(User.class, "username='username2'").forEach(u -> System.out.println(u.getUsername()));

    }
}
