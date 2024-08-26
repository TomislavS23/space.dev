package dev.space.dao;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author tomislav
 */
public class ArticleDAO {

    private Integer idArticle;
    private String title;
    private String link;
    private String description;
    private String content;
    private Date datePublished;
    private Collection<CategoryDAO> categoryCollection;
    private JournalistDAO idJournalist;

    public ArticleDAO() {
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

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Collection<CategoryDAO> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<CategoryDAO> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public JournalistDAO getIdJournalist() {
        return idJournalist;
    }

    public void setIdJournalist(JournalistDAO idJournalist) {
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
        final ArticleDAO other = (ArticleDAO) obj;
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
