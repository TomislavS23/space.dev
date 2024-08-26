package dev.space.session;

import dev.space.model.Article;
import dev.space.model.Category;
import dev.space.model.Journalist;
import dev.space.model.Role;
import dev.space.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tomislav
 */
public final class DatabaseSession {

    private static final String URL = "jdbc:postgresql://localhost:5432/spacedev";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public DatabaseSession() {
    }

    public static SessionFactory InitializeSession() {

        SessionFactory session
                = new Configuration()
                        .addAnnotatedClass(Article.class)
                        .addAnnotatedClass(Category.class)
                        .addAnnotatedClass(Journalist.class)
                        .addAnnotatedClass(Role.class)
                        .addAnnotatedClass(User.class)
                        // PostgreSQL
                        .setProperty(AvailableSettings.JAKARTA_JDBC_URL, URL)
                        // Credentials
                        .setProperty(AvailableSettings.JAKARTA_JDBC_USER, USERNAME)
                        .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, PASSWORD)
                        // SQL statement logging
                        .setProperty(AvailableSettings.SHOW_SQL, true)
                        .setProperty(AvailableSettings.FORMAT_SQL, true)
                        .setProperty(AvailableSettings.HIGHLIGHT_SQL, true)
                        // Create a new DatabaseSession
                        .buildSessionFactory();

        return session;
    }
}
