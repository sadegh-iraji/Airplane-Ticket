package ir.maktab.flightticket.servlet.operatorservlets;

import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class NewTicketConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Operator operator = (Operator) SecurityContext.getActiveUser();
        Airline airline = operator.getAirline();
        City origin = City.valueOf(req.getParameter("origin"));
        City destination = City.valueOf(req.getParameter("destination"));
        double price = Double.parseDouble(req.getParameter("price"));
        int capacity = Integer.parseInt(req.getParameter("capacity"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        LocalTime time = LocalTime.parse(req.getParameter("time"));

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en' >\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n");

        try {
            Ticket ticket = new Ticket(price, capacity, origin, destination, airline, date, time);
            airline.getTickets().add(ticket);
            ApplicationContext.getAirlineService().save(airline);
            out.println("<h2 align='center'> *** Ticket Added successfully *** </h2>");
        } catch (Exception e){
            e.printStackTrace();
            out.println("<h2 align='center'> ====> Something Wrong <==== </h2>");
        }

        out.println(
                "    <p>\n" +
                        "        <a href='operatorMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p>\n" +
                        "</body>\n" +
                        "</html>"
        );

    }
}
