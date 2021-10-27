package ir.maktab.flightticket.servlet.adminservlets;

import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AddNewOperator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Airline> airlines = ApplicationContext.getAirlineService().findAll();

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
                "<h2 align='center'>Add New Operator</h2>\n" +
                        "    <form action='newOperatorConfirm'>\n" +
                        "        <table align='center'> \n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='n_code'>National Code : </label></td>\n" +
                        "                <td align='left'><input type='text' name='nationalCode' id='n_code' placeholder='Ten Digits' required='required' pattern='[0-9]{10}'></td></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='u_name'>Username : </label></td>\n" +
                        "                <td align='left'><input type='text' name='username' id='u_name' required='required' pattern='.+'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='p_word'>Password : </label></td>\n" +
                        "                <td align='left'><input type='password' name='password' id='p_word' required='required' pattern='.+'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='airline'>Airline : </label></td>\n" +
                        "                <td align='left'>\n" +
                        "                    <select name='airlineName' id='airline'>\n"
        );

        for (Airline airline : airlines){
            out.println(
                    "<option value='" + airline.getName() + "'>" + airline.getName() + "</option>"
            );
        }
        out.println(
                        "                    </select>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td><input type='submit' value='New Operator Submit'></td>\n" +
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
