package dev.space.session;

import dev.space.model.Article;
import dev.space.model.Category;
import dev.space.model.Journalist;
import dev.space.model.Role;
import dev.space.model.Users;
import dev.space.query.implementation.ArticleOperationsImpl;
import dev.space.query.implementation.CategoryOperationsImpl;
import dev.space.query.implementation.JournalistOperationsImpl;
import dev.space.query.implementation.RoleOperationsImpl;
import dev.space.query.implementation.UserOperationsImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tomislav
 */
public final class HibernateSessionFactory {

    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/spacedev";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static final SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    static {
        sessionFactory
                = new Configuration()
                        .addAnnotatedClass(Article.class)
                        .addAnnotatedClass(Category.class)
                        .addAnnotatedClass(Journalist.class)
                        .addAnnotatedClass(Role.class)
                        .addAnnotatedClass(Users.class)
                        // PostgreSQL
                        .setProperty(AvailableSettings.JAKARTA_JDBC_URL, CONNECTION_STRING)
                        // Credentials
                        .setProperty(AvailableSettings.JAKARTA_JDBC_USER, USERNAME)
                        .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, PASSWORD)
                        // SQL statement logging
                        .setProperty(AvailableSettings.SHOW_SQL, true)
                        .setProperty(AvailableSettings.FORMAT_SQL, true)
                        .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
                        // Create a new HibernateSessionFactory
                        .buildSessionFactory();
    }

    public static <T> T InitializeSession(Operations operation) {

        switch (operation) {
            case USER:
                return (T) new UserOperationsImpl(sessionFactory);
            case ROLE:
                return (T) new RoleOperationsImpl(sessionFactory);
            case JOURNALIST:
                return (T) new JournalistOperationsImpl(sessionFactory);
            case CATEGORY:
                return (T) new CategoryOperationsImpl(sessionFactory);
            case ARTICLE:
                return (T) new ArticleOperationsImpl(sessionFactory);
            default:
                throw new IllegalArgumentException();
        }

    }
}
