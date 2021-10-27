package ir.maktab.flightticket.util;

import ir.maktab.flightticket.domain.enumetarion.City;

public class Authenticate {

    public static Boolean nationalCodeAuthenticate(String nationalCode) {
        return nationalCode.matches("[0-9]{10}");
    }

    public static City cityNameAuthenticate(String cityName){
        for (City city : City.values()){
            if (cityName.equalsIgnoreCase(city.name())){
                System.out.println("*** Origin Selected ***");
                return city;
            }
        }
        System.out.println("----> Choose a city from the List <-----");
        return null;
    }
}


