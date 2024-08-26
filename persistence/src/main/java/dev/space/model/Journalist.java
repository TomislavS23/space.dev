package dev.space.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author tomislav
 */
@Entity
@Table(name = "journalist")
public class Journalist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_journalist")
    private Integer idJournalist;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "idJournalist")
    private Collection<Article> articleCollection;

    public Journalist() {
    }

    public Journalist(Integer idJournalist) {
        this.idJournalist = idJournalist;
    }

    public Integer getIdJournalist() {
        return idJournalist;
    }

    public void setIdJournalist(Integer idJournalist) {
        this.idJournalist = idJournalist;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJournalist != null ? idJournalist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journalist)) {
            return false;
        }
        Journalist other = (Journalist) object;
        if ((this.idJournalist == null && other.idJournalist != null) || (this.idJournalist != null && !this.idJournalist.equals(other.idJournalist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.space.model.Journalist[ idJournalist=" + idJournalist + " ]";
    }
    
}
