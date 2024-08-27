package dev.space;

import dev.space.dto.UserDTO;
import dev.space.session.DatabaseSession;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tomislav
 */
@Deprecated
public class DatabaseTesting {

    public static void main(String[] args) {

        // Fun fact - I wasted about 6 hours trying to write basic select with join because,
        // for some reason, scaffolded classes hold reference to other tables by using objects
        // rather than storing id of an referenced object.
        // For example: SELECT u.username, u.password. r.roleType FROM Users AS u JOIN Role r ON u.idRole = r.idRole won't work
        // This will: SELECT u.username, u.password, role.roleType FROM Users AS u JOIN Role role ON u.idRole = role
        SessionFactory dbs = DatabaseSession.InitializeSession();
        Session session = dbs.openSession();

        try {
            List<UserDTO> resultList = session
                    .createSelectionQuery(
                            "SELECT new dev.space.dto.UserDTO(u.username, u.password, new dev.space.dto.RoleDTO(role.roleType)) FROM Users AS u JOIN Role role ON u.idRole = role", UserDTO.class)
                    .getResultList();

            resultList.forEach(r -> System.out.println(r.getUsername() + " " + r.getPassword() + " " + r.role.getRoleType()));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
