package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.base.domain.BaseEntity;
import ir.maktab.flightticket.domain.enumetarion.City;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ticket extends BaseEntity<Long> {

    private double price;

    private int capacity;

    @Enumerated(EnumType.STRING)
    private City origin;

    @Enumerated(EnumType.STRING)
    private City destination;

    @ManyToOne
    private Airline airline;

    private LocalDate date;

    private LocalTime time;

    public Ticket() {
    }

    public Ticket(double price, int capacity, City origin, City destination,
                  Airline airline, LocalDate date, LocalTime time) {
        this.price = price;
        this.capacity = capacity;
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.date = date;
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
