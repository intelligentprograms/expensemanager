package com.expensemanager.expensemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Document
public class User {
    @Id
    private String Id;
    @NotNull
    @Size(min = 3, max = 30)
    private String firstName;
    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;
    @NotNull
    @Size(min = 5, max = 30)
    private String login;
    @NotNull
    @Size(min = 5, max = 30)
    private String password;
    @Size(min = 0, max = 100)
    private String description;
    @Email
    @NotNull
    private String email;
    @NotNull
    private Integer groupId;
    @NotNull
    private Integer countryId;
    @NotNull
    private Integer languageId;
    @NotNull
    private Date dateOfBirth;
    private Date registrationDate;
    private List<Wallet> wallet;
    public User(){}

    /*TO DO: use builder pattern here*/
    public User(String id, String firstName, String lastName, String login, String password,
                String description, String email, Integer groupId, Integer countryId, Integer languageId,
                Date dateOfBirth, Date registrationDate, Wallet wallet) {
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
        this.wallet = (List<Wallet>) wallet;
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

    public List<Wallet> getWallet() { return wallet; }

    public void setWallet(List<Wallet> wallet) { this.wallet = wallet; }
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
                ", wallet=" + wallet +
                '}';
    }
}
