package dev.space;

import dev.space.dto.RoleDTO;
import dev.space.dto.UserDTO;
import dev.space.factory.MapperFactory;
import dev.space.model.Role;
import dev.space.model.Users;
import dev.space.query.operation.UserOperations;
import dev.space.session.HibernateSessionFactory;
import dev.space.session.Operations;
import org.modelmapper.ModelMapper;

/**
 *
 * @author tomislav
 */
@Deprecated
public class DatabaseTesting {

    public static void main(String[] args) {

        // NOTE (working join): SELECT u.username, u.password, role.roleType FROM Users AS u JOIN Role role ON u.idRole = role
        UserOperations session = HibernateSessionFactory.InitializeSession(Operations.USER);
        ModelMapper mapper = MapperFactory.InitializeMapper();

        try {
            UserDTO user = new UserDTO("miro", "Miric", new RoleDTO(1));
            Users entity = mapper.map(user, Users.class);
            entity.setIdRole(new Role(1));
            session.InsertEntity(entity);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
