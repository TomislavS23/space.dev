package dev.space.query.operation;

import dev.space.model.Article;
import dev.space.model.Category;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;

/**
 *
 * @author tomislav
 */
public interface ArticleOperations extends BaseOperations<Article> {

    Optional<List<Article>> ReadAllEntities() throws Exception, HibernateException;
    void AssignCategories(List<Category> entities, Integer id) throws Exception, HibernateException;
}
