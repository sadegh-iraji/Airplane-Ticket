package ir.maktab.flightticket.servlet.adminservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNewAirline extends HttpServlet {
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
                "<h2 align='center'>Add New Airline</h2>\n" +
                        "    <form action='newAirlineConfirm'>\n" +
                        "        <table align='center'> \n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='name'>Name of The Airline : </label></td>\n" +
                        "                <td align='left'><input type='text' required='required' pattern='.+' name='name' id='name'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td><input type='submit' value='New Airline Submit'></td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </form>"
        );

        out.println(
                "</body>\n" +
                        "</html>"
        );
    }
}
