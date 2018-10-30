package com.expensemanager.expensemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class User {
    @Id
    private String Id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String description;
    private String email;
    private Integer groupId;
    private Integer countryId;
    private Integer languageId;
    private Date dateOfBirth;
    private Date registrationDate;

    public User(){ }

    /*TO DO: use builder pattern here*/
    public User(String id, String firstName, String lastName, String login, String password, String description, String email, Integer groupId, Integer countryId, Integer languageId, Date dateOfBirth, Date registrationDate) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.description = description;
        this.email = email;
        this.groupId = groupId;
        this.countryId = countryId;
        this.languageId = languageId;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", groupId=" + groupId +
                ", countryId=" + countryId +
                ", languageId=" + languageId +
                ", dateOfBirth=" + dateOfBirth +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
