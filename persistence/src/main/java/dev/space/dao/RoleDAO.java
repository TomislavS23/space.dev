package dev.space.dao;

import java.util.Objects;

/**
 *
 * @author tomislav
 */
public class RoleDAO {
    private Integer idRole;
    private String roleType;

    public RoleDAO() {
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.roleType);
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
        final RoleDAO other = (RoleDAO) obj;
        return Objects.equals(this.roleType, other.roleType);
    }
    
    

    @Override
    public String toString() {
        return "RoleDAO{" + "idRole=" + idRole + ", roleType=" + roleType + '}';
    }
}
