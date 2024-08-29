package dev.space.query.operation;

import dev.space.model.Journalist;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface JournalistOperations extends BaseOperations<Journalist> {
    Optional<List<Journalist>> ReadAllEntities() throws Exception, HibernateException;
    Optional<List<Journalist>> ReadEntity(Journalist entity) throws Exception, HibernateException;
}
