package ir.maktab.flightticket.servlet.adminservlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewAirlineConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en' >\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h2> *** Airline added successfully *** </h2>"+
                        "    <p>\n" +
                        "        <a href='adminMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
