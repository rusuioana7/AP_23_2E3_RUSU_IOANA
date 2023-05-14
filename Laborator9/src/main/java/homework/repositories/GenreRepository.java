package homework.repositories;

import homework.entities.Genre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenreRepository extends DataRepository<Genre, Long> {
    private EntityManager entityManager;

    public GenreRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Genre genre) {
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
    }

    public Genre findById(int id) {
        return entityManager.find(Genre.class, id);
    }

    public List<Genre> findByName(String namePattern) {
        TypedQuery<Genre> query = entityManager.createNamedQuery("Genre.findByName", Genre.class);
        query.setParameter("namePattern", "%" + namePattern + "%");
        return query.getResultList();
    }

    @Override
    protected Class<Genre> getEntityClass() {
        return null;
    }
}
