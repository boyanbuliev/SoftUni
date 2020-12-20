import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Homework {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String MINIONS_TABLE_NAME = "minions_db";
    private Connection connection;
    private BufferedReader bf;

    public Homework() {
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        connection = DriverManager.getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);
    }

    public void getVillainsNames() throws SQLException {

        String query = "Select v.name, count(mv.minion_id) count FROM villains v " +
                "JOIN minions_villains mv ON v.id = mv.villain_id " +
                "GROUP BY mv.villain_id  HAVING count >15 ORDER BY count DESC";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString("name"),
                    resultSet.getInt("count"));
        }
    }

    public void getMinionNames() throws SQLException, IOException {
        System.out.println("Enter villain id: ");
        int villainId = Integer.parseInt(bf.readLine());
        String villainName = getEntityName(villainId, "villains");
        if (villainName == null) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }
        System.out.println("Villain: " + villainName);
        String query = "SELECT name, age FROM minions_villains mv\n" +
                "JOIN minions m on mv.minion_id = m.id\n" +
                "WHERE mv.villain_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();
        int counter = 1;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n", counter++, resultSet.getString("name"),
                    resultSet.getInt("age"));
        }
    }

    private String getEntityName(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getString("name") : null;
    }

    public void addMinion() throws IOException, SQLException {
        String[] minionInfo = bf.readLine().split("\\s+");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String villainName = bf.readLine().split("\\s+")[1];
        int townId = getEntityId(minionInfo[3], "towns");
        if (townId == -1) {
            insertEntityInTowns(minionInfo[3]);
            townId = getEntityId(minionInfo[3], "towns");
        }
        int villainId = getEntityId(villainName, "villains");
        if (villainId == -1) {
            insertEntityInVillains(villainName);
            villainId = getEntityId(villainName, "villains");
        }
        insertEntityInMinions(minionName, minionAge, townId);
        int minionId = getEntityId(minionName, "minions");
        insertEntityInMinionsVillains(minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private void insertEntityInMinionsVillains(int minionId, int villainId) throws SQLException {
        String query = "INSERT INTO minions_villains VALUES(?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, minionId);
        statement.setInt(2, villainId);
        statement.execute();
    }

    private void insertEntityInMinions(String minionName, int minionAge, int townId) throws SQLException {
        String query = "INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, minionName);
        statement.setInt(2, minionAge);
        statement.setInt(3, townId);
        statement.execute();
    }

    private void insertEntityInVillains(String villainInfo) throws SQLException {
        String query = "INSERT INTO villains(name, evilness_factor) VALUES(?, 3)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, villainInfo);
        statement.execute();
        System.out.printf("Villain %s was added to the database.%n", villainInfo);
    }

    private void insertEntityInTowns(String town) throws SQLException {
        String query = "INSERT INTO towns(name) VALUE(?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, town);
        statement.execute();
        System.out.printf("Town %s was added to the database.%n", town);
    }

    private int getEntityId(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next() ? resultSet.getInt(1) : -1;
    }

    public void changeTownNamesCasing() throws SQLException, IOException {
        String country = bf.readLine();
        String query = "UPDATE towns SET name = upper(name) WHERE country = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, country);
        int updatedTowns = statement.executeUpdate();
        if (updatedTowns > 0) {
            System.out.println(updatedTowns + " town names were affected.");
        } else {
            System.out.println("No town names were affected.");
            return;
        }
        PreparedStatement statement1 = connection.
                prepareStatement("SELECT name FROM towns WHERE country = ?");
        statement1.setString(1, country);
        ResultSet resultSet = statement1.executeQuery();
        List<String> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(resultSet.getString("name"));
        }
        System.out.println(list);
    }


    public void removeVillain() throws IOException, SQLException {
        int villainId = Integer.parseInt(bf.readLine());
        String villainName = getEntityName(villainId, "villains");
        if (villainName == null) {
            System.out.println("No such villain was found");
            return;
        }
        String query = "DELETE FROM minions_villains WHERE villain_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        int minionsReleased = statement.executeUpdate();
        query = "DELETE FROM villains WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        int villainRemoved = statement.executeUpdate();
        System.out.printf("%s was deleted%n%d minions released%n", villainName, minionsReleased);
    }

    public void printAllMinionNames() throws SQLException {
        String query = "SELECT name FROM minions";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<String> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(resultSet.getString("name"));
        }
        for (int i = 0; i < list.size() / 2; i++) {
            System.out.println(list.get(i));
            System.out.println(list.get(list.size() - 1 - i));
        }
        if (list.size() % 2 != 0) {
            System.out.println(list.get(list.size() / 2));
        }
    }

    public void increaseMinionsAge() throws SQLException, IOException {
        int[] ids = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        String param = "(";
//        for (int i = 0; i < ids.length; i++) {
//            param = param + "?,";
//        }
//        param = param.substring(0, param.length() - 1);
//        param = param + ")";
//        String query = String.format("UPDATE minions SET age = age + 1, name = lower(name) WHERE id IN%s", param);
//        PreparedStatement statement = connection.prepareStatement(query);
//        for (int i = 0; i < ids.length; i++) {
//            statement.setInt(i + 1, ids[i]);
//        }
        String query = String.format("UPDATE minions SET age = age + 1, name = lower(name) WHERE id IN(%s)",
                Arrays.stream(ids).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
        query = "SELECT name, age FROM minions";
        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
        }

    }

    public void increaseWithStoredProcedure() throws IOException, SQLException {
        int minionId = Integer.parseInt(bf.readLine());
        String query = "CALL usp_get_older(?)";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
        query = "SELECT name, age FROM minions WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, minionId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
        }
    }
}
