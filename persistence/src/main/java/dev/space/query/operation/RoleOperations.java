package dev.space.query.operation;

import dev.space.model.Role;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface RoleOperations extends BaseOperations<Role> {

    Optional<List<Role>> ReadAllEntities() throws Exception, HibernateException;
}
