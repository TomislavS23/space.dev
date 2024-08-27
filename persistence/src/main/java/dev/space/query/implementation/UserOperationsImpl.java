package dev.space.query.implementation;

import dev.space.model.Users;
import dev.space.query.operation.UserOperations;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomislav
 */
public class UserOperationsImpl implements UserOperations {

    private final SessionFactory sessionFactory;

    private static final String SELECT_USER = "FROM Users WHERE idUser = :param";
    private static final String SELECT_USERS = "FROM Users";
    private static final String DELETE_USER = "DELETE Users where idUser = :param";

    public UserOperationsImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     *
     * @return List
     * @throws java.lang.Exception
     * @throws HibernateException
     */
    @Override
    public List<Users> ReadAllEntities() throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return session
                    .createSelectionQuery(SELECT_USERS, Users.class)
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
    public void InsertEntity(Users entity) throws Exception, HibernateException {
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
    public void UpdateEntity(Users entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            Users result = session.createSelectionQuery(SELECT_USER, Users.class)
                    .setParameter("param", entity.getIdUser())
                    .getSingleResult();
            
            result.setUsername(entity.getUsername());
            result.setPassword(entity.getPassword());
            result.setIdRole(entity.getIdRole());
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
            session.createMutationQuery(DELETE_USER)
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
    public Users ReadEntityById(Integer id) throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return session
                    .createSelectionQuery(SELECT_USER, Users.class)
                    .setParameter("param", id)
                    .getSingleResult();

        } catch (Exception e) {
            throw e;
        }
    }

}
