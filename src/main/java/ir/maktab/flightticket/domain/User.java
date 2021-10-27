package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.base.domain.BaseEntity;
import ir.maktab.flightticket.domain.enumetarion.UserType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class User extends BaseEntity<Long> {

    private String username;

    private String password;

    private String NationalCode;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User() {
    }

    public User(String username, String password, String nationalCode, UserType userType) {
        this.username = username;
        this.password = password;
        NationalCode = nationalCode;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        NationalCode = nationalCode;
    }
}
