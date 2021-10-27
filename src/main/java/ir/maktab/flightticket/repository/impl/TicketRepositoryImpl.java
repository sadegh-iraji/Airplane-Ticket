package ir.maktab.flightticket.repository.impl;

import ir.maktab.flightticket.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;
import ir.maktab.flightticket.repository.TicketRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long> implements TicketRepository {

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    public List<Ticket> findTicketsByOriginAndDestination(City origin, City destination) {
        return entityManager.createQuery("from Ticket where " +
                        "origin =:origin and destination =:destination and DATE(date) >= DATE(:date)"
                , Ticket.class)
                .setParameter("origin", origin)
                .setParameter("destination", destination)
                .setParameter("date", LocalDate.now())
                .getResultList();
    }
}
