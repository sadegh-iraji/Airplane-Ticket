package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.base.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline extends BaseEntity<Long> {

    private String name;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.MERGE)
    private List<Operator> operators = new ArrayList<>();

    @OneToMany(mappedBy = "airline", cascade = CascadeType.MERGE)
    private List<Ticket> tickets = new ArrayList<>();

    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public Airline(String name, List<Operator> operators, List<Ticket> tickets) {
        this.name = name;
        this.operators = operators;
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
