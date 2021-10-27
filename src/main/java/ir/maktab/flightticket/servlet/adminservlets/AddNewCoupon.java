package ir.maktab.flightticket.servlet.adminservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNewCoupon extends HttpServlet {
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
                "<h2 align='center'>Add New Coupon</h2>\n" +
                        "    <form action='newCouponConfirm'>\n" +
                        "        <table align='center'> \n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='code'>Coupon Code: </label></td>\n" +
                        "                <td align='left'><input type='text' required='required' pattern='.+' name='code' id='code'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='discount_P'>Discount Percent : </label></td>\n" +
                        "                <td align='left'><input type='number' required='required' pattern='.+' min='1' max='100' name='discountPercent' id='discount_P'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='expire_d'>Expire Date : </label></td>\n" +
                        "                <td align='left'><input type='date' required='required' pattern='.+' name='expireDate' id='expire_d'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td><input type='submit' value='New Coupon Submit'></td>\n" +
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
