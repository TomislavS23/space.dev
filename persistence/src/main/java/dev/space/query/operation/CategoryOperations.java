package dev.space.query.operation;

import dev.space.model.Category;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface CategoryOperations extends BaseOperations<Category>{
    Optional<List<Category>> ReadAllEntities() throws Exception, HibernateException;
    Optional<List<Category>> ReadEntity(Category entity) throws Exception, HibernateException;
}
