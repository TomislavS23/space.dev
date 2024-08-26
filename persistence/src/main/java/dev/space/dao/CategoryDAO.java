package dev.space.dao;

import java.util.Objects;

/**
 *
 * @author tomislav
 */
public class CategoryDAO {

    private Integer idCategory;
    private String categoryType;

    public CategoryDAO() {
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.categoryType);
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
        final CategoryDAO other = (CategoryDAO) obj;
        return Objects.equals(this.categoryType, other.categoryType);
    }

    @Override
    public String toString() {
        return "CategoryDAO{" + "categoryType=" + categoryType + '}';
    }

}
