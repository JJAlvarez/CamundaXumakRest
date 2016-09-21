package org.xumak.camunda.spring.bean;

/**
 * Created by xumak on 14/09/16.
 */
public class UserBean {

    private String uid;
    private String firstName;
    private String lastName;
    private String mail;

    public UserBean(String uId, String firstName, String lastName, String mail) {
        this.uid = uId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    public UserBean() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
