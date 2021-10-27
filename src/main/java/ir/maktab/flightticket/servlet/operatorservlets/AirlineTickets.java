package ir.maktab.flightticket.servlet.operatorservlets;

import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AirlineTickets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Operator operator = (Operator) SecurityContext.getActiveUser();
        List<Ticket> tickets = operator.getAirline().getTickets();

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h2>Tickets</h2>\n" +
                        "    <hr>\n");
        for (Ticket ticket : tickets) {
            out.println(
                    "<hr>\n" +
                            "    <p>\n" +
                            "        <table align='center'>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>Ticket ID : " + ticket.getId() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>From : " + ticket.getOrigin() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>To : " + ticket.getDestination() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>Airline : " + ticket.getAirline().getName() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>Price : " + ticket.getPrice() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>Date : " + ticket.getDate() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "                <td align='right'>Time : " + ticket.getTime() + "</td>\n" +
                            "                <td></td>\n" +
                            "            </tr>\n" +
                            "        </table>\n" +
                            "    </p>\n" +
                            "    <hr>"
            );
        }
        out.println(
                "    <p>\n" +
                        "        <a href='operatorMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p><br><br><br>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>"
        );


    }
}
