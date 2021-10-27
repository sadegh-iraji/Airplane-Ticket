package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
                "<html>\n" +
                        "<head>\n" +
                        "    <link rel=\"stylesheet\" href='resource/styles/style.css'>\n" +
                        "</head>"
        );
        out.println(
                "<body>\n" +
                        "  <h1>Customer Main Menu</h1>\n" +
                        "  <h2 align='center'>Welcome Dear " + SecurityContext.getActiveUser().getUsername() + "</h2>\n" +
                        "  <div id='divMenu'>\n" +
                        "    <ul>\n" +
                        "      <li><a href='customerProfile'>Your Profile and Edition</a></li>\n" +
                        "      <li><a href='originDestinationChoose'>Buy Ticket</a></li>\n" +
                        "      <li><a href='customerTickets'>Show Your Tickets</a></li>\n" +
                        "      <li><a href='signOut'>SIGN OUT</a></li>" +
                        "    </ul>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>"
        );
    }
}
