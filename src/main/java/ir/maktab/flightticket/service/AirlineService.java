package ir.maktab.flightticket.service;

import ir.maktab.flightticket.base.service.BaseService;
import ir.maktab.flightticket.domain.Airline;

public interface AirlineService extends BaseService<Airline, Long> {

    Airline findByName(String airlineName);
}
