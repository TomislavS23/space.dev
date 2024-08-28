package dev.space.query.operation;

import dev.space.model.Users;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface UserOperations extends BaseOperations<Users> {

    Optional<List<Users>> ReadAllEntities() throws Exception, HibernateException;
    Optional<List<Users>> ReadEntity(Users entity) throws Exception, HibernateException;
}
