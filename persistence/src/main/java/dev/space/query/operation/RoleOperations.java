package dev.space.query.operation;

import dev.space.model.Role;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface RoleOperations extends BaseOperations<Role> {

    List<Role> ReadAllEntities() throws Exception, HibernateException;
}
