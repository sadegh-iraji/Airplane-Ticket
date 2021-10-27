package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.domain.enumetarion.UserType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Operator extends User {

    @ManyToOne
    private Airline airline;

    public Operator() {
    }

    public Operator(String username, String password, String nationalCode, UserType userType) {
        super(username, password, nationalCode, userType);
    }

    public Operator(String username, String password, String nationalCode, UserType userType, Airline airline) {
        super(username, password, nationalCode, userType);
        this.airline = airline;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
