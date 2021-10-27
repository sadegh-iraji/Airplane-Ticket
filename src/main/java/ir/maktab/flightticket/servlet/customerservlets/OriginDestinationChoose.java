package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.domain.enumetarion.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OriginDestinationChoose extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        City[] cities = City.values();

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h2>Origin and Destination of Your Flight</h2>\n" +
                        "    <form action='ticketChoose'>\n" +
                        "<table align='center'>" +
                        "<tr>" +
                        "        <td><label for='origin'>From : </label>\n" +
                        "        <select name='origin' id='origin'>"
        );

        for (City city : cities) {
            out.println(
                    "<option value='" + city + "'>" + city.name() + "</option>"
            );
        }

        out.println(
                "</select>\n" +
                        "        <label for='destination'>To : </label>\n" +
                        "        <select name='destination' id='destination'>"
        );

        for (City city : cities) {
            out.println(
                    "<option value='" + city + "'>" + city.name() + "</option>"
            );
        }

        out.println(
                "</select><td>\n" +
                        "</tr>" +
                        "<tr>" +
                        "        <td colspan='2'><input type='submit' value='Search For Available Tickets'></td>\n" +
                        "</table>" +
                        "    </form>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
