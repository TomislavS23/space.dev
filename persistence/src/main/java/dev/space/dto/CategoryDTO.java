package dev.space.dto;

import java.util.Objects;

/**
 *
 * @author tomislav
 */
public class CategoryDTO {

    private Integer idCategory;
    private String categoryType;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer idCategory) {
        this.idCategory = idCategory;
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
        final CategoryDTO other = (CategoryDTO) obj;
        return Objects.equals(this.categoryType, other.categoryType);
    }

    @Override
    public String toString() {
        return "CategoryDAO{" + "categoryType=" + categoryType + '}';
    }

}
