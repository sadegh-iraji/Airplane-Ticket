package ir.maktab.flightticket.filter.customerfilters;

import ir.maktab.flightticket.domain.Coupon;
import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.domain.Ticket;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class BuyTicketFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Customer customer = (Customer) SecurityContext.getActiveUser();
        long id = Long.parseLong(servletRequest.getParameter("ticketId"));
        Ticket ticket = ApplicationContext.getTicketService().findById(id);
        PrintWriter out = servletResponse.getWriter();

        String couponCode = servletRequest.getParameter("couponCode");

        if (couponCode.isEmpty()) {
            if (ticket.getPrice() > customer.getBalance()) {
                out.println(
                        "<!DOCTYPE html>\n" +
                                "<html lang='en'>\n" +
                                "<head>\n" +
                                "    <meta charset='UTF-8'>\n" +
                                "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "    <h2> ==> Not Enough Balance <== </h2>\n" +
                                "    <p>\n" +
                                "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                                "    </p>\n" +
                                "</body>\n" +
                                "</html>"
                );
            } else if (ticket.getCapacity() < 1) {
                out.println(
                        "<!DOCTYPE html>\n" +
                                "<html lang='en'>\n" +
                                "<head>\n" +
                                "    <meta charset='UTF-8'>\n" +
                                "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "    <h2> ==> No Capacity Left for this Flight <== </h2>\n" +
                                "    <p>\n" +
                                "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                "    </p>\n" +
                                "</body>\n" +
                                "</html>"
                );
            } else if(ticket.getDate().equals(LocalDate.now() ) && ticket.getTime().compareTo(LocalTime.now()) <0){
                out.println(
                        "<!DOCTYPE html>\n" +
                                "<html lang='en'>\n" +
                                "<head>\n" +
                                "    <meta charset='UTF-8'>\n" +
                                "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "    <h2> ==> Flight Time is Passed <== </h2>\n" +
                                "    <p>\n" +
                                "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                "    </p>\n" +
                                "</body>\n" +
                                "</html>"
                );
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            try {
                Coupon coupon = ApplicationContext.getCouponService().findCouponByCode(couponCode);
                Set<Customer> couponCustomers = coupon.getCustomers();
                if (coupon.getExpireDate().compareTo(LocalDate.now()) < 0) {
                    out.println(
                            "<!DOCTYPE html>\n" +
                                    "<html lang='en'>\n" +
                                    "<head>\n" +
                                    "    <meta charset='UTF-8'>\n" +
                                    "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "    <h2> ==> Coupon Expired <== </h2>\n" +
                                    "    <p>\n" +
                                    "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                    "    </p>\n" +
                                    "</body>\n" +
                                    "</html>"
                    );
                } else if (couponCustomers.contains(customer)) {
                    out.println(
                            "<!DOCTYPE html>\n" +
                                    "<html lang='en'>\n" +
                                    "<head>\n" +
                                    "    <meta charset='UTF-8'>\n" +
                                    "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "    <h2> ==> You Used This Coupon Before <== </h2>\n" +
                                    "    <p>\n" +
                                    "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                    "    </p>\n" +
                                    "</body>\n" +
                                    "</html>"
                    );
                } else if (((100 - coupon.getDiscountPercent()) / 100 * ticket.getPrice() > customer.getBalance())) {
                    out.println(
                            "<!DOCTYPE html>\n" +
                                    "<html lang='en'>\n" +
                                    "<head>\n" +
                                    "    <meta charset='UTF-8'>\n" +
                                    "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "    <h2> ==> Not Enough Balance <== </h2>\n" +
                                    "    <p>\n" +
                                    "        <a href='customerMain' class='underline'>Return to Main Menu</a>\n" +
                                    "    </p>\n" +
                                    "</body>\n" +
                                    "</html>"
                    );

                } else if (ticket.getCapacity() < 1) {
                    out.println(
                            "<!DOCTYPE html>\n" +
                                    "<html lang='en'>\n" +
                                    "<head>\n" +
                                    "    <meta charset='UTF-8'>\n" +
                                    "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "    <h2> ==> No Capacity Left for this Flight <== </h2>\n" +
                                    "    <p>\n" +
                                    "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                    "    </p>\n" +
                                    "</body>\n" +
                                    "</html>"
                    );
                } else if(ticket.getDate().equals(LocalDate.now() ) && ticket.getTime().compareTo(LocalTime.now()) <0){
                    out.println(
                            "<!DOCTYPE html>\n" +
                                    "<html lang='en'>\n" +
                                    "<head>\n" +
                                    "    <meta charset='UTF-8'>\n" +
                                    "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "    <h2> ==> Flight Time is Passed <== </h2>\n" +
                                    "    <p>\n" +
                                    "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                    "    </p>\n" +
                                    "</body>\n" +
                                    "</html>"
                    );
                }else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println(
                        "<!DOCTYPE html>\n" +
                                "<html lang='en'>\n" +
                                "<head>\n" +
                                "    <meta charset='UTF-8'>\n" +
                                "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "    <h2> ==> Wrong Coupon Code <== </h2>\n" +
                                "    <p>\n" +
                                "        <a href='originDestinationChoose' class='underline'>Return to Buy Ticket</a>\n" +
                                "    </p>\n" +
                                "</body>\n" +
                                "</html>"
                );
            }
        }
    }
}
