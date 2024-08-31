package dev.space.query.implementation;

import dev.space.model.Journalist;
import dev.space.model.Users;
import dev.space.query.operation.JournalistOperations;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomislav
 */
public class JournalistOperationsImpl implements JournalistOperations {
    
    private final SessionFactory sessionFactory;
    
    private static final String SELECT_JOURNALIST = "FROM Journalist WHERE idJournalist = :param";
    private static final String SELECT_JOURNALIST_BY_VALUES = "FROM Journalist WHERE firstName = :param1 AND lastName = :param2";
    private static final String SELECT_JOURNALISTS = "FROM Journalist";
    private static final String DELETE_JOURNALIST = "DELETE Journalist where idJournalist = :param";
    private static final String DELETE_ALL_JOURNALISTS = "DELETE Journalist";
    
    public JournalistOperationsImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return List
     * @throws java.lang.Exception
     * @throws HibernateException
     */
    @Override
    public Optional<List<Journalist>> ReadAllEntities() throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return Optional.of(session
                    .createSelectionQuery(SELECT_JOURNALISTS, Journalist.class)
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
    public void InsertEntity(Journalist entity) throws Exception, HibernateException {
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
    public void UpdateEntity(Journalist entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            Journalist result = session.createSelectionQuery(SELECT_JOURNALIST, Journalist.class)
                    .setParameter("param", entity.getIdJournalist())
                    .getSingleResult();
            
            result.setFirstName(entity.getFirstName());
            result.setLastName(entity.getLastName());
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
            session.createMutationQuery(DELETE_JOURNALIST)
                    .setParameter("param", id)
                    .executeUpdate();
        });
    }

    /**
     *
     * @param id
     * @return Journalist
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public Optional<Journalist> ReadEntityById(Integer id) throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return Optional.of(session
                    .createSelectionQuery(SELECT_JOURNALIST, Journalist.class)
                    .setParameter("param", id)
                    .getSingleResult());
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void DeleteAllEntities() throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(DELETE_ALL_JOURNALISTS)
                    .executeUpdate();
        });
    }
    
    @Override
    public Optional<List<Journalist>> ReadEntity(Journalist entity) throws Exception, HibernateException {
        Session session = sessionFactory.openSession();
        return Optional.of(session
                .createSelectionQuery(SELECT_JOURNALIST_BY_VALUES, Journalist.class)
                .setParameter("param1", entity.getFirstName())
                .setParameter("param2", entity.getLastName())
                .getResultList());
    }
    
}
