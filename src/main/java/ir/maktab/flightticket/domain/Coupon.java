package ir.maktab.flightticket.domain;

import ir.maktab.flightticket.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Coupon extends BaseEntity<Long> {

    private String code;

    private double discountPercent;

    private LocalDate expireDate;

    @ManyToMany
    private Set<Customer> customers = new HashSet<>();

    public Coupon() {
    }

    public Coupon(String code,double discountPercent, LocalDate expireDate) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.expireDate = expireDate;
    }

    public Coupon(double discountPercent, LocalDate expireDate, Set<Customer> customers) {
        this.discountPercent = discountPercent;
        this.expireDate = expireDate;
        this.customers = customers;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
