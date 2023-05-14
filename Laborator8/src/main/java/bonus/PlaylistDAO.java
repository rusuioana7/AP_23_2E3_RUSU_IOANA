package bonus;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlaylistDAO {


    public void insertRandomPlaylist() {
        String query = "INSERT INTO playlistalbums (id,created_at,albums) VALUES (?,?,?)";
        Random rand = new Random();

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            int id = rand.nextInt(1, 50);
            Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());
            List<String> albumTitles = new ArrayList<>();
            String selectQuery = "SELECT title FROM albumcomplet";
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery)) {
                while (rs.next()) {
                    albumTitles.add(rs.getString("title"));
                }
            }
            Collections.shuffle(albumTitles);
            List<String> selectedAlbums = albumTitles.subList(0, rand.nextInt(10) + 1);
            String albumsString = String.join(",", selectedAlbums);
            pstmt.setInt(1, id);
            pstmt.setTimestamp(2, createdAt);
            pstmt.setString(3, albumsString);
            pstmt.executeUpdate();
            System.out.println("Random playlist inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
