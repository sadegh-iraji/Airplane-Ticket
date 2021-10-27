package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.domain.enumetarion.UserType;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin() {
    }

    public Admin(String username, String password, String nationalCode, UserType userType) {
        super(username, password, nationalCode, userType);
    }
}
