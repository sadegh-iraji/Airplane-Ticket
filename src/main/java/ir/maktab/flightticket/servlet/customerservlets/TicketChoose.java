package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.domain.enumetarion.City;
import ir.maktab.flightticket.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TicketChoose extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        City origin = City.valueOf(req.getParameter("origin"));
        City destination = City.valueOf(req.getParameter("destination"));

        List<Ticket> tickets = ApplicationContext.
                getTicketService().findTicketsByOriginAndDestination(origin, destination);

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n"
        );

        if (tickets.isEmpty()) {
            out.println(
                    "<h2> ====> No Ticket is Available For You <==== </h2>" +
                            "</body>" +
                            "</html>"
            );
        } else {
            out.println(
                    "<h2>Tickets</h2>"
            );

            for (Ticket ticket : tickets) {
                out.println(
                        "        <table align='center'>\n" +
                                "            <tr>\n" +
                                "                <td>From : </td>\n" +
                                "                <td> " + ticket.getOrigin() + " </td>\n" +
                                "            </tr>\n" +
                                "            <tr>\n" +
                                "                <td>To : </td>\n" +
                                "                <td>" + ticket.getDestination() + "</td>\n" +
                                "            </tr>\n" +
                                "            <tr>\n" +
                                "                <td>Airline : </td>\n" +
                                "                <td>" + ticket.getAirline().getName() + "</td>\n" +
                                "            </tr>\n" +
                                "            <tr>\n" +
                                "                 <td>Price : </td>\n");

                if (ticket.getDate().equals(LocalDate.now())
                        && ticket.getTime().compareTo(LocalTime.now()) > 0
                        && Duration.between(LocalTime.now(), ticket.getTime()).toMinutes() < 60) {
                    out.println(
                            "<td><del>" + ticket.getPrice() + "</del> <ins>" + ticket.getPrice() / 2 + "</ins></td>\n"
                    );
                } else {
                    out.println(
                            "<td>" + ticket.getPrice() + "</td>\n"
                    );
                }
                out.println(
                        "            </tr>\n" +
                                "            <tr>\n" +
                                "                <td>Date : </td>\n" +
                                "                <td>" + ticket.getDate() + "</td>\n" +
                                "            </tr>\n" +
                                "            <tr>\n" +
                                "                <td>Time : </td>\n" +
                                "                <td>" + ticket.getTime() + "</td>\n" +
                                "            </tr>\n" +
                                "           <form action='buyTicket'>\n" +
                                "            <tr>\n" +
                                "                <td><label for='couponCode'>Coupon Code : </label></td>\n" +
                                "                <td><input type='text' name='couponCode' id='couponCode'></td>\n" +
                                "            </tr>\n" +
                                "            <tr>\n" +
                                "                <td>\n" +
                                "                    <input type='hidden' name='ticketId' value='" + ticket.getId() + "'>\n" +
                                "                    <input type='submit' value='Buy The Ticket'>\n" +
                                "                </td>\n" +
                                "            </tr>\n" +
                                "            </form>" +
                                "        </table>\n" +
                                "    <hr>"
                );

            }

        }

        out.println(
                "    <p>\n" +
                        "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p><br><br><br>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
