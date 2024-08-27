package dev.space.query.operation;

import dev.space.model.Users;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface UserOperations extends BaseOperations<Users> {

    List<Users> ReadAllEntities() throws Exception, HibernateException;
}
