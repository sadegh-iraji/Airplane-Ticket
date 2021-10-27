package ir.maktab.flightticket.servlet.adminservlets;

import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.domain.Operator;
import ir.maktab.flightticket.domain.enumetarion.UserType;
import ir.maktab.flightticket.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewOperatorConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nationalCode = req.getParameter("nationalCode");
        String airlineName = req.getParameter("airlineName");

        Airline airline = ApplicationContext.getAirlineService().findByName(airlineName);
        Operator operator = new Operator(username, password, nationalCode, UserType.OPERATOR);

        airline.getOperators().add(operator);
        operator.setAirline(airline);

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en' >\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                        "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n");

        try {
            ApplicationContext.getAirlineService().save(airline);
            out.println("<h2 align='center'> *** Operator added successfully *** </h2>");
        } catch (Exception e){
            e.printStackTrace();
            out.println("<h2 align='center'> ====> Something Wrong <==== </h2>");
        }

        out.println(
                "    <p>\n" +
                        "        <a href='adminMain' class='underline'>Return to Main Menu</a>\n" +
                        "    </p>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
