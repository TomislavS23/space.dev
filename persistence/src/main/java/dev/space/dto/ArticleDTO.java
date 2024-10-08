package dev.space.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tomislav
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"title", "link", "description", "content", "datePublished", "picturePath", "idJournalist", "categoryCollection"})
public class ArticleDTO {

    @XmlAttribute
    private Integer idArticle;
    private String title;
    private String link;
    private String description;
    private String content;
    private String picturePath;

    private Date datePublished;
    @XmlElementWrapper
    @XmlElement(name = "category")
    private Collection<CategoryDTO> categoryCollection;
    private JournalistDTO idJournalist;

    public ArticleDTO() {
    }

    public ArticleDTO(Integer idArticle, String title, String link, String description, String content, String picturePath, Date datePublished, Collection<CategoryDTO> categoryCollection, JournalistDTO idJournalist) {
        this.idArticle = idArticle;
        this.title = title;
        this.link = link;
        this.description = description;
        this.content = content;
        this.picturePath = picturePath;
        this.datePublished = datePublished;
        this.categoryCollection = categoryCollection;
        this.idJournalist = idJournalist;
    }

    public ArticleDTO(String title, String link, String description, String content, String picturePath, Date datePublished, Collection<CategoryDTO> categoryCollection, JournalistDTO idJournalist) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.content = content;
        this.picturePath = picturePath;
        this.datePublished = datePublished;
        this.categoryCollection = categoryCollection;
        this.idJournalist = idJournalist;
    }

    public ArticleDTO(String title, String link, String description, String content, Date datePublished, Collection<CategoryDTO> categoryCollection, JournalistDTO idJournalist) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.content = content;
        this.datePublished = datePublished;
        this.categoryCollection = categoryCollection;
        this.idJournalist = idJournalist;
    }

    public ArticleDTO(String title, String link, String description, String content, Date datePublished, Collection<CategoryDTO> categoryCollection) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.content = content;
        this.datePublished = datePublished;
        this.categoryCollection = categoryCollection;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Collection<CategoryDTO> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<CategoryDTO> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public JournalistDTO getIdJournalist() {
        return idJournalist;
    }

    public void setIdJournalist(JournalistDTO idJournalist) {
        this.idJournalist = idJournalist;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.link);
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
        final ArticleDTO other = (ArticleDTO) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.link, other.link);
    }

    @Override
    public String toString() {
        return "ArticleDAO{" + "idArticle=" + idArticle + ", title=" + title + ", link=" + link + ", description=" + description + '}';
    }

}
