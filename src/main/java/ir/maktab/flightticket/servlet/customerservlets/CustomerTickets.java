package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class CustomerTickets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Customer customer = (Customer) SecurityContext.getActiveUser();
        Set<Ticket> tickets = customer.getTickets();

        if (tickets.isEmpty()){
            out.println(
                    "<!DOCTYPE html>\n" +
                            "<html lang='en'>\n" +
                            "<head>\n" +
                            "    <meta charset='UTF-8'>\n" +
                            "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h2> ===> You Don't Have Any Tickets Bought <===== </h2>\n" +
                            "    <p>\n" +
                            "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                            "    </p>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h2> Your Tickets </h2>\n");

        for (Ticket ticket : tickets) {
            out.println(
                    "<hr>\n" +
                            "    <p>\n" +
                            "        <table align='center'>\n" +
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
                            "        </table><br><br>\n" +
                            "    </p>\n" +
                            "    <p>\n" +
                            "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                            "    </p>\n" +
                            "    <hr>"
            );
        }
        out.println(
                "           </body>\n" +
                        "</html>"
        );

    }
}
