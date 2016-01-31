package com.blogger;

import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by kolyan on 31.01.16.
 */
@ApplicationScoped
public class MainDaoImpl implements MainDao {

    @PersistenceContext(name = "transport")
    private EntityManager entityManager;

    @Override
    public Session getSession() {
        return (Session) entityManager.getDelegate();
    }

    @Override
    public <E> void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public <E> E read(Class<E> entity, Object id) {
        return entityManager.find(entity, id);
    }

    @Override
    public <E> E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public <E> void delete(E entity) {
        if (!entityManager.contains(entity)) {
            entity = entityManager.merge(entity);
        }
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> findAll(Class<E> entity) {
        return entityManager.createQuery(String.format("SELECT e FROM %s e", entity.getName()))
                .getResultList();
    }
}
