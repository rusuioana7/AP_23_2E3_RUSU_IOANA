package optional;

import java.sql.*;
import java.util.Random;


public class ArtistDAO implements Music {
    public void create(String name) throws SQLException {// insert a new artist into the table with a random ID and the specified name.
        Connection connection = Database.getConnection();
        Random random = new Random();
        int id = random.nextInt(1, 50);
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into artists (id, name) values (?, ?)")) {//insert statement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();//execute the statement
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(//select statement for getting the artist's id from the db based on the name
                     "select id from artists where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select name from artists where id=" + id)) {//select statement for getting the artist's name from the db based on the id
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }
}
