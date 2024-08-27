package dev.space.dto;

import java.util.Objects;

/**
 *
 * @author tomislav
 */
public final class UserDTO {

    public Integer idUser;
    public String username;
    public String password;
    public RoleDTO idRole;

    public UserDTO() {
    }

    public UserDTO(String username, String password, RoleDTO idRole) {
        this.username = username;
        this.password = password;
        this.idRole = idRole;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRole() {
        return idRole;
    }

    public void setRole(RoleDTO idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDTO other = (UserDTO) obj;
        return Objects.equals(this.username, other.username);
    }
}
