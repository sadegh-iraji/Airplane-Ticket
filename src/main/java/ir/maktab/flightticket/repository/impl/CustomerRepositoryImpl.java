package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
