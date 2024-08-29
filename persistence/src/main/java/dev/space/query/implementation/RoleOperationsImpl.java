package dev.space.query.implementation;

import dev.space.model.Role;
import dev.space.query.operation.RoleOperations;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tomislav
 */
public class RoleOperationsImpl implements RoleOperations {

    private final SessionFactory sessionFactory;

    private static final String SELECT_ROLE = "FROM Role WHERE idRole = :param";
    private static final String SELECT_ROLES = "FROM Role";
    private static final String INSERT_ROLE = "INSERT Role(roleType) VALUES(:param)";
    private static final String DELETE_ROLE = "DELETE Role where idRole = :param";
     private static final String DELETE_ALL_ROLES = "DELETE Role";

    public RoleOperationsImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     *
     * @return List
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public List<Role> ReadAllEntities() throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return session
                    .createSelectionQuery(SELECT_ROLES, Role.class)
                    .getResultList();

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param entity
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public void InsertEntity(Role entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(INSERT_ROLE)
                    .setParameter("param", entity.getRoleType())
                    .executeUpdate();
        });
    }

    /**
     *
     * @param entity
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public void UpdateEntity(Role entity) throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            Role result = session.createSelectionQuery(SELECT_ROLE, Role.class)
                    .setParameter("param", entity.getIdRole())
                    .getSingleResult();
            
            result.setRoleType(entity.getRoleType());
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
            session.createMutationQuery(DELETE_ROLE)
                    .setParameter("param", id)
                    .executeUpdate();
        });
    }

    /**
     *
     * @param id
     * @return Role
     * @throws Exception
     * @throws HibernateException
     */
    @Override
    public Role ReadEntityById(Integer id) throws Exception, HibernateException {
        try {
            Session session = sessionFactory.openSession();
            return session
                    .createSelectionQuery(SELECT_ROLE, Role.class)
                    .setParameter("param", id)
                    .getSingleResult();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void DeleteAllEntities() throws Exception, HibernateException {
        sessionFactory.inTransaction(session -> {
            session.createMutationQuery(DELETE_ALL_ROLES)
                    .executeUpdate();
        });
    }

}
