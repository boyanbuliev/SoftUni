package Diablo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        String path = Main.class.getClassLoader()
                .getResource("jdbc.properties").getPath();
        System.out.println(path);

        try {
            props.load(new FileInputStream("src\\jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = sc.nextLine().trim();
        username = username.length() > 0 ? username : "Alex";
        System.out.println(props);
        try (Connection con = DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password"));
             PreparedStatement ps = con.prepareStatement(props.getProperty("sql.games"))) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getLong("id") != 0) {
                    System.out.printf("| %10d | %-15.15s | %-15.15s | %10d |%n",
                            rs.getLong("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getInt("count"));
                } else {
                    System.out.printf("DB user with username %s not found", username);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}