package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.domain.enumetarion.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends User {

    private double balance;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "customer_ticket",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id")})
    private Set<Ticket> tickets = new HashSet<>();

    public Customer() {
    }

    public Customer(String username, String password, String nationalCode,
                    UserType userType, double balance) {
        super(username, password, nationalCode, userType);
        this.balance = balance;
    }

    public Customer(String username, String password, String nationalCode,
                    UserType userType, double balance, Set<Ticket> tickets) {
        super(username, password, nationalCode, userType);
        this.balance = balance;
        this.tickets = tickets;
    }

    public Customer(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
