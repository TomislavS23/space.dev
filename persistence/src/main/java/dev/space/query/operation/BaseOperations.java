package dev.space.query.operation;

import java.util.Optional;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface BaseOperations<T> {
    void InsertEntity(T entity) throws Exception, HibernateException;
    void UpdateEntity(T entity) throws Exception, HibernateException;
    void DeleteEntity(Integer id) throws Exception, HibernateException;
    void DeleteAllEntities() throws Exception, HibernateException;
    Optional<T> ReadEntityById(Integer id) throws Exception, HibernateException;
}
