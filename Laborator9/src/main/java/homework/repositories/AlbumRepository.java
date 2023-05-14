package homework.repositories;


import homework.entities.Album;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository extends DataRepository<Album, Long> {
    private EntityManager entityManager;

    public AlbumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }


    public List<Album> findByName(String namePattern) {
        TypedQuery<Album> query = entityManager.createNamedQuery("Album.findByName", Album.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();

    }

    @Override
    protected Class<Album> getEntityClass() {
        return null;
    }
}

