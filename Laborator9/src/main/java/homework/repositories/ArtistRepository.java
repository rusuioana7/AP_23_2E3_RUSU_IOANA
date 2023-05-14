package homework.repositories;

import homework.entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository extends DataRepository<Artist, Long> {
    private EntityManager entityManager;

    public ArtistRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }


    public List<Artist> findByName(String namePattern) {
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }

    @Override
    protected Class<Artist> getEntityClass() {
        return null;
    }
}

