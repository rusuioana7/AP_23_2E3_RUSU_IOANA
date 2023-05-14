package bonus;

import java.sql.*;
import java.util.Random;

public class GenreDAO implements Music {
    public void create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        Random random = new Random();
        int id = random.nextInt(1, 50);
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into genres (id, name) values (?, ?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select name from genres where id=" + id)) {
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }
}
