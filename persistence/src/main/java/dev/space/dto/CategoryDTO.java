package dev.space.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

/**
 *
 * @author tomislav
 */
@XmlAccessorType(XmlAccessType.FIELD)

public class CategoryDTO implements Comparable<CategoryDTO> {

    private Integer idCategory;
    private String categoryType;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer idCategory, String categoryType) {
        this.idCategory = idCategory;
        this.categoryType = categoryType;
    }

    public CategoryDTO(String categoryType) {
        this.categoryType = categoryType;
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
        return categoryType;
    }

    @Override
    public int compareTo(CategoryDTO o) {
        return categoryType.compareTo(o.categoryType);
    }

}
