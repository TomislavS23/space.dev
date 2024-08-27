package dev.space.query.operation;

import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface BaseOperations<T> {
    void InsertEntity(T entity) throws Exception, HibernateException;
    void UpdateEntity(T entity) throws Exception, HibernateException;
    void DeleteEntity(Integer id) throws Exception, HibernateException;
    T ReadEntityById(Integer id) throws Exception, HibernateException;
}
