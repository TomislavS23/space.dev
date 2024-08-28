package dev.space.query.implementation;

import dev.space.model.Article;
import dev.space.model.Category;
import dev.space.query.operation.ArticleOperations;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomislav
 */
public class ArticleOperationsImpl implements ArticleOperations {

    private final SessionFactory sessionFactory;

    private static final String SELECT_ARTICLE = "FROM Article WHERE idArticle = :param";
    private static final String SELECT_ARTICLES = "FROM Article";
    private static final String DELETE_ARTICLE = "DELETE Article where idArticle = :param";

    public ArticleOperationsImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return List
     * @throws java.lang.Exception
     * @throws HibernateException
     */
    @Override
    public List<Article> ReadAllEntities() throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return session
                    .createSelectionQuery(SELECT_ARTICLES, Article.class)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param entity
     * @throws java.lang.Exception
     * @throws HibernateException
     */
    @Override
    public void InsertEntity(Article entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            session.persist(entity);
        });
    }

    /**
     *
     * @param entity
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public void UpdateEntity(Article entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            Article result = session.createSelectionQuery(SELECT_ARTICLE, Article.class)
                    .setParameter("param", entity.getIdArticle())
                    .getSingleResult();

            result.setTitle(entity.getTitle());
            result.setLink(entity.getLink());
            result.setDescription(entity.getDescription());
            result.setContent(entity.getContent());
            result.setDatePublished(entity.getDatePublished());
            result.setIdJournalist(entity.getIdJournalist());
        });
    }

    /**
     *
     * @param id
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public void DeleteEntity(Integer id) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(DELETE_ARTICLE)
                    .setParameter("param", id)
                    .executeUpdate();
        });
    }

    /**
     *
     * @param id
     * @return Article
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public Article ReadEntityById(Integer id) throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return session
                    .createSelectionQuery(SELECT_ARTICLE, Article.class)
                    .setParameter("param", id)
                    .getSingleResult();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void AssignCategories(List<Category> entities, Integer id) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            Article result = session
                    .createSelectionQuery(SELECT_ARTICLE, Article.class)
                    .setParameter("param", id)
                    .getSingleResult();
            
            result.getCategoryCollection().addAll(entities);
        });
    }

}
