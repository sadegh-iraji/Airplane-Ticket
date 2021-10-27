package ir.maktab.flightticket.servlet.operatorservlets;

import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OperatorMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "  <h1>Operator Main Menu</h1>\n" +
                        "  <h2 align='center'>Welcome " + SecurityContext.getActiveUser().getUsername() + "</h2>\n" +
                        "  <div id='divMenu'>\n" +
                        "    <ul>\n" +
                        "      <li><a href='operatorProfile'>Your Profile and Edition</a></li>\n" +
                        "      <li><a href='airlineTickets'>Tickets of Your Airline</a></li>\n" +
                        "      <li><a href='addNewTicket'>Add New Ticket</a></li>\n" +
                        "      <li><a href='signOut'>SIGN OUT</a></li>" +
                        "    </ul>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>"
        );
    }
}
