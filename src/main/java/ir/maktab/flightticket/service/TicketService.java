package ir.maktab.flightticket.service;

import ir.maktab.flightticket.base.service.BaseService;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;

import java.util.List;

public interface TicketService extends BaseService<Ticket, Long> {

    List<Ticket> findTicketsByOriginAndDestination(City origin, City destination);

}
