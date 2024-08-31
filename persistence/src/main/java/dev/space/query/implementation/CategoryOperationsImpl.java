package dev.space.query.implementation;

import dev.space.model.Category;
import dev.space.query.operation.CategoryOperations;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomislav
 */
public class CategoryOperationsImpl implements CategoryOperations {
    
    private final SessionFactory sessionFactory;
    
    private static final String SELECT_CATEGORY = "FROM Category WHERE idCategory = :param";
    private static final String SELECT_CATEGORY_BY_TYPE = "FROM Category WHERE categoryType = :param";
    private static final String SELECT_CATEGORIES = "FROM Category";
    private static final String DELETE_CATEGORY = "DELETE Category where idCategory = :param";
    private static final String DELETE_ALL_CATEGORIES = "DELETE Category";
    
    public CategoryOperationsImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return List
     * @throws java.lang.Exception
     * @throws HibernateException
     */
    @Override
    public Optional<List<Category>> ReadAllEntities() throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return Optional.of(session
                    .createSelectionQuery(SELECT_CATEGORIES, Category.class)
                    .getResultList());
            
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
    public void InsertEntity(Category entity) throws Exception, HibernateException {
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
    public void UpdateEntity(Category entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            Category result = session.createSelectionQuery(SELECT_CATEGORY, Category.class)
                    .setParameter("param", entity.getIdCategory())
                    .getSingleResult();
            
            result.setCategoryType(entity.getCategoryType());
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
            session.createMutationQuery(DELETE_CATEGORY)
                    .setParameter("param", id)
                    .executeUpdate();
        });
    }

    /**
     *
     * @param id
     * @return Users
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public Optional<Category> ReadEntityById(Integer id) throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return Optional.of(session
                    .createSelectionQuery(SELECT_CATEGORY, Category.class)
                    .setParameter("param", id)
                    .getSingleResult());
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void DeleteAllEntities() throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(DELETE_ALL_CATEGORIES)
                    .executeUpdate();
        });
    }
    
    @Override
    public Optional<List<Category>> ReadEntity(Category entity) throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return Optional.of(session
                    .createSelectionQuery(SELECT_CATEGORY_BY_TYPE, Category.class)
                    .setParameter("param", entity.getCategoryType())
                    .getResultList());
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
