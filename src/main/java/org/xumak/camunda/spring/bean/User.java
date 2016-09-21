package org.xumak.camunda.spring.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by xumak on 14/09/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "User")
public class User {

    @Id
    private String userId;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "mail", nullable = false)
    private String mail;

    @NotNull
    @Column(name = "startDate", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "numberOfFreeDays", nullable = false)
    private Integer numberOfFreeDays;

    public User() {

    }

    public User(String userId, String name, String mail, Date startDate, Integer numberOfFreeDays) {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.startDate = startDate;
        this.numberOfFreeDays = numberOfFreeDays;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getNumberOfFreeDays() {
        return numberOfFreeDays;
    }

    public void setNumberOfFreeDays(Integer numberOfFreeDays) {
        this.numberOfFreeDays = numberOfFreeDays;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (userId.equals(null)) {
            if (!userId.equals(null))
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

}
