package dev.space.query.operation;

import dev.space.model.Category;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface CategoryOperations extends BaseOperations<Category>{
    List<Category> ReadAllEntities() throws Exception, HibernateException;
}
