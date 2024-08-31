package dev.space.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

/**
 *
 * @author tomislav
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class JournalistDTO {

    private Integer idJournalist;
    private String firstName;
    private String lastName;

    public JournalistDTO() {
    }

    public JournalistDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public JournalistDTO(Integer idJournalist, String firstName, String lastName) {
        this.idJournalist = idJournalist;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public JournalistDTO(Integer idJournalist) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idJournalist);
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
        final JournalistDTO other = (JournalistDTO) obj;
        return Objects.equals(this.idJournalist, other.idJournalist);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
