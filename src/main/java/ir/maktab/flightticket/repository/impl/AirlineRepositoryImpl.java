package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.repository.AirlineRrpository;

import javax.persistence.EntityManager;

public class AirlineRepositoryImpl extends BaseRepositoryImpl<Airline, Long> implements AirlineRrpository {

    public AirlineRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Airline> getEntityClass() {
        return Airline.class;
    }

    @Override
    public Airline findByName(String airlineName) {
        return entityManager.createQuery("from Airline where name = :name", Airline.class)
                .setParameter("name", airlineName).getSingleResult();
    }
}
