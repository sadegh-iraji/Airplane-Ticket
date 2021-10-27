package ir.maktab.flightticket.servlet.customerservlets;

import ir.maktab.flightticket.domain.Coupon;
import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class BuyTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Customer customer = (Customer) SecurityContext.getActiveUser();
        String couponCode = req.getParameter("couponCode");
        long id = Long.parseLong(req.getParameter("ticketId"));
        Ticket ticket = ApplicationContext.getTicketService().findById(id);
        double balance = customer.getBalance();
        int capacity = ticket.getCapacity();
        double price;
        double finalPrice;
        String explain = "";

        try {
            if (LocalDate.now().equals(ticket.getDate())
                    && ticket.getTime().compareTo(LocalTime.now()) > 0
                    && Duration.between(LocalTime.now(), ticket.getTime()).toMinutes() < 60){
                price = ticket.getPrice()/2;
                explain += "50 Percent For Time,. ";
            } else {
                price = ticket.getPrice();
            }

            if (couponCode.isEmpty()){
                finalPrice = price;
            } else {
                Coupon coupon = ApplicationContext.getCouponService().findCouponByCode(couponCode);
                finalPrice = price * ((100-coupon.getDiscountPercent())/100);
                coupon.getCustomers().add(customer);
                ApplicationContext.getCouponService().save(coupon);
                explain += coupon.getDiscountPercent() + " Percent For Coupon,. ";
            }

            if (!customer.getTickets().isEmpty() && customer.getTickets().size()%10 == 0){
                finalPrice = 0;
                explain = "100 Percent For 10 Tickets Bought Lately";
            }

            ticket.setCapacity(capacity-1);
            customer.setBalance(balance-finalPrice);
            customer.getTickets().add(ticket);
            ApplicationContext.getCustomerService().save(customer);
            out.println(
                    "<!DOCTYPE html>\n" +
                            "<html lang='en'>\n" +
                            "<head>\n" +
                            "    <meta charset='UTF-8'>\n" +
                            "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h2> *** Ticket Bought Successfully *** </h2>\n");
            if (!explain.equals("")){
                out.println("    <h3 align='center'> Your Discounts : " + explain + "</h3>");
            }
            out.println(
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
                            "    <h2> ==> Something Wrong <== </h2>\n" +
                            "    <p>\n" +
                            "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                            "    </p>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }


    }
}
