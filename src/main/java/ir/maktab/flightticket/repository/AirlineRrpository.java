package ir.maktab.flightticket.repository;

import ir.maktab.flightticket.base.repository.BaseRepository;
import ir.maktab.flightticket.domain.Airline;

public interface AirlineRrpository extends BaseRepository<Airline, Long> {

    Airline findByName(String airlineName);
}
