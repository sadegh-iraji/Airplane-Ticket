package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IncreaseBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Customer customer = (Customer) SecurityContext.getActiveUser();
        double balance = customer.getBalance();
        double increaseBalance = Double.parseDouble(req.getParameter("balance"));

        try {
            customer.setBalance(balance + increaseBalance);
            ApplicationContext.getUserService().save(customer);
            out.println(
                    "<!DOCTYPE html>\n" +
                            "<html lang='en'>\n" +
                            "<head>\n" +
                            "    <meta charset='UTF-8'>\n" +
                            "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h2> *** Balance Increased Successfully *** </h2>\n" +
                            "    <p>\n" +
                            "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                            "    </p>\n" +
                            "</body>\n" +
                            "</html>"
            );
        } catch (Exception e){
            e.printStackTrace();
            out.println(
                    "<!DOCTYPE html>\n" +
                            "<html lang='en'>\n" +
                            "<head>\n" +
                            "    <meta charset='UTF-8'>\n" +
                            "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h2> ====> Something Wrong <==== </h2>\n" +
                            "    <p>\n" +
                            "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                            "    </p>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }

    }
}
