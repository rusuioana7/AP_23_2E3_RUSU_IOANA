package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            System.out.println("Artist id:" + artists.findByName("Pink Floyd"));
            Database.getConnection().commit();
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Pop");
            System.out.println("Genre id:" + genres.findByName("Rock"));
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.PrintAlbum();

            Database.getConnection().commit();

            Database.getConnection().close();
        } catch ( SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
