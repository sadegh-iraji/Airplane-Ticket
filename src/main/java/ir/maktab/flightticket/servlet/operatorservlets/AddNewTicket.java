package ir.maktab.flightticket.servlet.operatorservlets;

import ir.maktab.flightticket.domain.enumetarion.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNewTicket extends HttpServlet {
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
                        "    <h2 align='center'>Add New Ticket</h2>\n" +
                        "    <form action='newTicketConfirm'>\n" +
                        "        <table align='center'>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='origin'>From : </label></td>\n" +
                        "                <td align='left'>\n" +
                        "                    <select name='origin' id='origin'>\n");
        for (City city : cities) {
            out.println(
                    "<option value='" + city + "'>" + city.name() + "</option>"
            );
        }
        out.println(
                "  </select>\n" +
                        "   </td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "   <td align='right'><label for='destination'>To : </label></td>\n" +
                        "   <td align='left'>\n" +
                        "       <select name='destination' id='destination'>"
        );


        for (City city : cities) {
            out.println(
                    "<option value='" + city + "'>" + city.name() + "</option>"
            );
        }
        out.println(
                " </select>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='price'>Price : </label></td>\n" +
                        "                <td align='left'><input type='number' required='required' pattern='.+' min='1' name='price' id='price'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='capacity'>Capacity : </label></td>\n" +
                        "                <td align='left'><input type='number' required='required' pattern='.+' min='1' name='capacity' id='capacity'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='date'>Date : </label></td>\n" +
                        "                <td align='left'><input type='date' required='required' pattern='.+' min='' name='date'id='date'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='time'>Time : </label></td>\n" +
                        "                <td align='left'><input type='time' required='required' pattern='.+' min='' name='time'id='time'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td><input type='submit' value='New Ticket Submit'></td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </form>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>"
        );
    }
}
