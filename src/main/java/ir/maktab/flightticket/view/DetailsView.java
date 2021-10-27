package ir.maktab.flightticket.view;

import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;

import java.util.Collection;
import java.util.List;

public class DetailsView {

    public static void airlineListView(List<Airline> airlines){
        for (Airline airline : airlines){
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                            "ID : " + airline.getId() + "\n" +
                            "Name : " + airline.getName() + "\n" +
                            "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
            );
        }

    }

    public static void operatorListView(List<Operator> operators){
        for (Operator operator : operators){
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                            "ID: " + operator.getId() + "\n" +
                            "Username: " + operator.getUsername() + "\n" +
                            "National Code: " + operator.getNationalCode() + "\n" +
                            "Airline: " + operator.getAirline() + "\n" +
                            "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
            );
        }
    }

    public static void operatorProfileView(Operator operator){
        System.out.println(
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "Your Username: " + operator.getUsername() + "\n" +
                        "Your National Code: " + operator.getNationalCode() + "\n" +
                        "Your Airline: " + operator.getAirline().getName() + "\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
        );
    }

    public static void ticketListView(Collection<Ticket> tickets){
        for (Ticket ticket : tickets){
            System.out.println(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                            "Ticket ID: " + ticket.getId() + "\n" +
                            "From : " + ticket.getOrigin() + "\n" +
                            "To : " + ticket.getDestination() + "\n" +
                            "Airline : " + ticket.getAirline().getName() + "\n" +
                            "Price : " + ticket.getPrice() + "\n" +
                            "Date : " + ticket.getDate() + "\n" +
                            "Time : " + ticket.getTime() + "\n" +
                            "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
            );
        }
    }

    public static void cities(){
        City[] cities = City.values();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (City city : cities){
            System.out.println(city.toString());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public static void customerView(Customer activeCustomer) {
        System.out.println(
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "Your Username : " + activeCustomer.getUsername() + "\n" +
                        "Your National Code : " + activeCustomer.getNationalCode() + "\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
        );
    }
}
