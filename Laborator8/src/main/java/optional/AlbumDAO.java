package optional;

import java.sql.*;
import java.util.Random;

public class AlbumDAO implements Music {
    int id;

    public void create(int year, String name, String artist, String genre) throws SQLException {
        Connection connection = Database.getConnection();
        Random random = new Random();
        id = random.nextInt(1, 50);
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into albums (id, release_year, title, artist, genre) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, year);
            pstmt.setString(3, name);
            pstmt.setString(4, artist);
            pstmt.setString(5, genre);


            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select id, release_year, artist, genre from albums where title='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select release_year, title, artist, genre from albums where id=" + id)) {
            return resultSet.next() ? resultSet.getString(1) : null;


        }
    }

    public void PrintAlbum() throws SQLException {

        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from albums")) {
            while (resultSet.next()) {
                int idd = resultSet.getInt("id");
                int release_year = resultSet.getInt("release_year");
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                String genre = resultSet.getString("genre");
                System.out.println("Album: " + idd + " " + release_year + " " + title + " " + artist + " " + genre);


            }


        }


    }
}
