package ir.maktab.flightticket.service.impl;

import ir.maktab.flightticket.base.service.impl.BaseServiceImpl;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;
import ir.maktab.flightticket.repository.TicketRepository;
import ir.maktab.flightticket.service.TicketService;

import java.util.Comparator;
import java.util.List;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository>
        implements TicketService {

    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> findTicketsByOriginAndDestination(City origin, City destination) {
        return repository.findTicketsByOriginAndDestination(origin, destination);
    }

    public static class AirlineComparator implements Comparator<Ticket>{

        @Override
        public int compare(Ticket ticket1, Ticket ticket2) {
            return ticket1.getAirline().getName().compareTo(ticket2.getAirline().getName());
        }
    }

    public static class OriginComparator implements Comparator<Ticket>{

        @Override
        public int compare(Ticket ticket1, Ticket ticket2) {
            return ticket1.getOrigin().compareTo(ticket2.getOrigin());
        }
    }

    public static class DestinationComparator implements Comparator<Ticket>{

        @Override
        public int compare(Ticket ticket1, Ticket ticket2) {
            return ticket1.getDestination().compareTo(ticket2.getDestination());
        }
    }

    public static class DateCompataror implements Comparator<Ticket>{


        @Override
        public int compare(Ticket ticket1, Ticket ticket2) {
            return ticket1.getDate().compareTo(ticket2.getDate());
        }
    }
}
