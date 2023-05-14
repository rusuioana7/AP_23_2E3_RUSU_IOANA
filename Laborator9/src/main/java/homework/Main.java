package homework;

import com.github.javafaker.Faker;
import homework.entities.Album;
import homework.entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createNativeQuery("DROP TABLE artists").executeUpdate();
        em.createNativeQuery("DROP TABLE albums").executeUpdate();
        em.createNativeQuery("DROP TABLE genres").executeUpdate();


        em.createNativeQuery("CREATE TABLE artists (id INTEGER PRIMARY KEY, name VARCHAR(200))").executeUpdate();
        em.createNativeQuery("CREATE TABLE albums (id INTEGER PRIMARY KEY, release_year INTEGER, title VARCHAR(200), artist VARCHAR(200), genre VARCHAR(200))").executeUpdate();
        em.createNativeQuery("CREATE TABLE genres (id INTEGER PRIMARY KEY, name VARCHAR(200))").executeUpdate();


        Faker faker = new Faker();
        int numArtists = 100;
        int numAlbums = 5;

        List<Artist> fakeArtists = new ArrayList<>();
        List<Album> fakeAlbums = new ArrayList<>();


        for (int i = 0; i < numArtists; i++) {
            String artistName = faker.name().fullName();
            Artist artist = new Artist(artistName);
            fakeArtists.add(artist);
        }

        for (int j = 0; j < numAlbums; j++) {
            String title = faker.book().title();//fake album title de fapt
            Album album = new Album(title);
            album.setId(j + 1);
            fakeAlbums.add(album);
        }

        long startTime = System.currentTimeMillis();


        for (Artist artist : fakeArtists) {
            em.persist(artist);
        }


        for (Album album : fakeAlbums) {
            em.createNativeQuery("INSERT INTO albums (id, title) VALUES (?, ?)")
                    .setParameter(1, album.getId())
                    .setParameter(2, album.getName())
                    .executeUpdate();

        }

        em.getTransaction().commit();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + " milliseconds");


        em.close();
        emf.close();

    }

}
