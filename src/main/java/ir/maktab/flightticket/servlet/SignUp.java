package ir.maktab.flightticket.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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
                "<h2 align=\"center\">Sign Up</h2>\n" +
                        "    <form action=\"signUpConfirm\">\n" +
                        "        <table align=\"center\"> \n" +
                        "            <tr>\n" +
                        "                <td align=\"right\"><label for=\"nationalCode\">National Code : </label></td>\n" +
                        "                <td align=\"left\"><input type=\"text\" name=\"nationalCode\" id=\"nationalCode\" placeholder='Ten Digits' required='required' pattern='[0-9]{10}'></td></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align=\"right\"><label for=\"username\">Username : </label></td>\n" +
                        "                <td align=\"left\"><input type=\"text\" name=\"username\" id=\"username\" required='required' pattern='.+'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align=\"right\"><label for=\"password\">Password : </label></td>\n" +
                        "                <td align=\"left\"><input type=\"password\" name=\"password\" id=\"password\" required='required' pattern='.+'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td><input type=\"submit\" value=\"Sign Up Submit\"></td>\n" +
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
