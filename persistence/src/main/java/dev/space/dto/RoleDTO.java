package dev.space.dto;

import java.util.Objects;

/**
 *
 * @author tomislav
 */
public class RoleDTO {

    private Integer idRole;
    private String roleType;

    public RoleDTO() {
    }

    public RoleDTO(String roleType) {
        this.roleType = roleType;
    }

    public RoleDTO(Integer idRole, String roleType) {
        this.idRole = idRole;
        this.roleType = roleType;
    }

    public RoleDTO(Integer idRole) {
        this.idRole = idRole;
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
        final RoleDTO other = (RoleDTO) obj;
        return Objects.equals(this.roleType, other.roleType);
    }

    @Override
    public String toString() {
        return "RoleDAO{" + "idRole=" + idRole + ", roleType=" + roleType + '}';
    }
}
