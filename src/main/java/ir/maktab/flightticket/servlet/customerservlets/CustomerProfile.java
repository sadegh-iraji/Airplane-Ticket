package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) SecurityContext.getActiveUser();
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
                        "    <h2 align='center'> Profile </h2>\n" +
                        "    <p align='center'>\n" +
                        "        Your Username : " + customer.getUsername() + "<br>\n" +
                        "        Your National Code : " + customer.getNationalCode() + "<br>\n" +
                        "        Your Account Balance : " + customer.getBalance() + "<br>\n" +
                        "    </p>\n" +
                        "    <h4 align='center'> ✅ If You Want to Change Your Username or Password You Can Do It Below </h4>\n" +
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
                        "                <td align='left'><input type='password' required='required' pattern='.+' name='password' id='password'>\n" +
                        "                </td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td align='center'><input type='submit' value='New Password Submit'></td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </form><br>\n" +
                        "    <form action='increaseBalance'>\n" +
                        "        <table align='center'>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='balance'>Balance Increase Amount : </label></td>\n" +
                        "                <td align='left'><input type='number' required='required' pattern='.+' min='1' name='balance' id='balance'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td align='center'><input type='submit' value='Balance Increase Submit'></td>\n" +
                        "            </tr>\n" +
                        "        </table>\n" +
                        "    </form><br>\n" +
                        "    <p>\n" +
                        "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>"
        );
    }
}
