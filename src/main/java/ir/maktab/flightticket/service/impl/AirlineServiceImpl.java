package ir.maktab.flightticket.service.impl;

import ir.maktab.flightticket.base.service.impl.BaseServiceImpl;
import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.repository.AirlineRrpository;
import ir.maktab.flightticket.service.AirlineService;

public class AirlineServiceImpl extends BaseServiceImpl<Airline, Long, AirlineRrpository>
        implements AirlineService {

    public AirlineServiceImpl(AirlineRrpository repository) {
        super(repository);
    }

    @Override
    public Airline findByName(String airlineName) {
        return repository.findByName(airlineName);
    }
}
