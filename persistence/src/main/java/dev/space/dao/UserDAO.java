package dev.space.dao;

import java.util.Objects;

/**
 *
 * @author tomislav
 */
public final class UserDAO{
    public Integer IdUser;
    public String username;
    public String password;

    public UserDAO() {
    }

    public Integer getIdUser() {
        return IdUser;
    }

    public void setIdUser(Integer IdUser) {
        this.IdUser = IdUser;
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
        final UserDAO other = (UserDAO) obj;
        return Objects.equals(this.username, other.username);
    }
}
