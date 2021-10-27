package ir.maktab.flightticket.servlet.adminservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminMain extends HttpServlet {
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
                        "<body>\n"
        );

        out.println(
                "<body>" +
                        "<h1>Admin Main Menu</h1>\n" +
                        "    <h2 align='center'>Welcome Dear ADMIN</h2>\n" +
                        "    <div id='divMenu'>\n" +
                        "<ul>\n" +
                        "        <li><a href='newAirline'>Add New Airline</a></li>\n" +
                        "    </ul>\n" +
                        "    <ul>\n" +
                        "        <li><a href='newOperator'>Add New Operator</a></li>\n" +
                        "    </ul>" +
                        "<ul>\n" +
                        "        <li><a href='newCoupon'>Add New Coupon</a></li>\n" +
                        "    </ul>" +
                        "<ul>\n" +
                        "        <li><a href='signOut'>SIGN OUT</a></li>\n" +
                        "    </ul>" +
                        "    </div>"
        );

        out.println(
                "</body>" +
                        "</html>"
        );
    }
}
