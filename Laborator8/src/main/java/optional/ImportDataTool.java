package optional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.*;

public class ImportDataTool {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\ioana\\facultate\\2-sem2\\JAVA\\Laborator8\\albumlist.csv";
        String line;
        String lineSplitBy = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO albumcomplet (id, release_year, title, artist, genre, subgenre) VALUES (?, ?, ?, ?, ?, ?)")) {


            while ((line = br.readLine()) != null) {
                String[] albumData = line.split(lineSplitBy);
                int id = parseInt(albumData[0]);

                int releaseYear = parseInt(albumData[1]);

                String title = albumData[2];
                String artist = albumData[3];
                String genre = albumData[4];
                String subgenre = albumData[5];

                pstmt.setInt(1, id);
                pstmt.setInt(2, releaseYear);
                pstmt.setString(3, title);
                pstmt.setString(4, artist);
                pstmt.setString(5, genre);
                pstmt.setString(6, subgenre);
                pstmt.addBatch();


            }

            pstmt.executeBatch();
            System.out.println("Data imported successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}