package ir.maktab.flightticket.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignIn extends HttpServlet {
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
                "<h2 align='center'>Sign In</h2>\n" +
                        "    <form action='signInConfirm'>\n" +
                        "        <table align='center'> \n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='u_name'>Username : </label></td>\n" +
                        "                <td align='left'><input type='text' name='username' id='u_name' required='required' pattern='.+'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td align='right'><label for='p_word'>Password : </label></td>\n" +
                        "                <td align='left'><input type='password' name='password' id='p_word' required='required' pattern='.+'></td>\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <td></td>\n" +
                        "                <td><input type='submit' value='Sign In Submit'></td>\n" +
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
