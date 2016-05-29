package ua.teachme.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.teachme.model.Notation;
import ua.teachme.repository.NotationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class JpaNotationRepositoryImpl implements NotationRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notation> getBetween(LocalDateTime start, LocalDateTime end) {
        return entityManager.createNamedQuery(Notation.GET_BETWEEN, Notation.class)
                .setParameter("startDateAndTime", start)
                .setParameter("endDateAndTime", end)
                .getResultList();
    }

    @Override
    public List<Notation> getAll() {
        return entityManager.createNamedQuery(Notation.GET_ALL, Notation.class).getResultList();
    }

    @Override
    public Notation save(Notation entity) {
        if (entity.isNew()){
            entityManager.persist(entity);
            return entity;
        }
        else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public Notation get(int id) {
        return entityManager.find(Notation.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.createNamedQuery(Notation.DELETE).setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Notation> getByUserId(int userId) {
        return entityManager.createNamedQuery(Notation.GET_BY_USER_ID, Notation.class).setParameter("userId", userId).getResultList();
    }
}
