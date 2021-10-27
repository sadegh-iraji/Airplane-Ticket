package ir.maktab.flightticket.repository;

import ir.maktab.flightticket.base.repository.BaseRepository;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket, Long> {

    List<Ticket> findTicketsByOriginAndDestination(City origin, City destination);
}
