package dev.space;

import dev.space.dto.ArticleDTO;
import dev.space.dto.CategoryDTO;
import dev.space.dto.JournalistDTO;
import dev.space.factory.MapperFactory;
import dev.space.model.Article;
import dev.space.model.Category;
import dev.space.query.operation.ArticleOperations;
import dev.space.session.HibernateSessionFactory;
import dev.space.session.Operations;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;

/**
 *
 * @author tomislav
 */
@Deprecated
public class DatabaseTesting {

    public static void main(String[] args) {

        // NOTE (working join): SELECT u.username, u.password, role.roleType FROM Users AS u JOIN Role role ON u.idRole = role
        ArticleOperations session = HibernateSessionFactory.InitializeSession(Operations.ARTICLE);
        ModelMapper mapper = MapperFactory.InitializeMapper();

        try {
            /*List<CategoryDTO> entities = new ArrayList<>();
            entities.add(new CategoryDTO(1));
            List<Category> categories = new ArrayList<>();
            for (CategoryDTO entity : entities) {
            categories.add(mapper.map(entity, Category.class));
            }
            session.AssignCategories(categories, 2);*/
            
            Article entity = session.ReadEntityById(2);
            ArticleDTO mappedEntity = mapper.map(entity, ArticleDTO.class);
            
            System.out.println("done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
