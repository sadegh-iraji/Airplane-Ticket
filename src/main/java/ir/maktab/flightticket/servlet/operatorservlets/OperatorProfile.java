package ir.maktab.flightticket.servlet.operatorservlets;

import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OperatorProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Operator operator = (Operator) SecurityContext.getActiveUser();
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
                        "    <h2 align='center'> Profile </h2>\n" +
                        "    <p align='center'>\n" +
                        "        Your Username : " + operator.getUsername() + "<br>\n" +
                        "        Your National Code : " + operator.getNationalCode() + "<br>\n" +
                        "        Your Airline : " + operator.getAirline().getName() + "<br>\n" +
                        "    </p>\n" +
                        "<hr>" +
                        "<h4 align='center'> If You Want to Change Your Username or Password You Can Do It Below </h4>\n" +
                        "<hr>" +
                        "    <form action='editUsername'>\n" +
                        "        <table align='center'>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='username'>New Username : </label></td>\n" +
                        "                <td align='left'><input type='text' required='required' pattern='.+' name='username' id='username'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td align='center'><input type='submit' value='New Username Submit'></td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </form><br>\n" +
                        "    <form action='editPassword'>\n" +
                        "        <table align='center'>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='password'>New Password : </label></td>\n" +
                        "                <td align='left'><input type='password' required='required' pattern='.+' name='password' id='password'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td align='center'><input type='submit' value='New Password Submit'></td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </form><br>" +
                        "<p>\n" +
                        "        <a href='operatorMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p>" +
                        "</body>\n" +
                        "</html>"
        );

    }
}
