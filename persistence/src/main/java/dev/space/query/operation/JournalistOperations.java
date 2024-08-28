package dev.space.query.operation;

import dev.space.model.Journalist;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface JournalistOperations extends BaseOperations<Journalist> {
    List<Journalist> ReadAllEntities() throws Exception, HibernateException;
}
