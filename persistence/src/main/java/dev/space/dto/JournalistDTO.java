package dev.space.dto;

import java.util.Collection;

/**
 *
 * @author tomislav
 */
public class JournalistDTO {

    private Integer idJournalist;
    private String firstName;
    private String lastName;

    public JournalistDTO() {
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

}
