package com.blogger;

import org.hibernate.Session;

import java.util.List;

/**
 * @author kolyan
 * @since 1.0
 */
public interface MainDao {

    Session getSession();

    <E> void create(E entity);

    <E> E read(Class<E> entity, Object id);

    <E> E update(E entity);

    <E> void delete(E entity);

    <E> List<E> findAll(Class<E> entity);
}
