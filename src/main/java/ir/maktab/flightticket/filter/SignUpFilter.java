package ir.maktab.flightticket.filter;

import ir.maktab.flightticket.domain.Customer;
import ir.maktab.flightticket.domain.enumetarion.UserType;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.Authenticate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String nationalCode = httpServletRequest.getParameter("nationalCode");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n"
        );


        if (!Authenticate.nationalCodeAuthenticate(nationalCode)) {
            out.println("<h3 align='center'> ----> National Code Must Contains Only 10 Digits <---- </h3>\n" +
                    "<p align='center'><a href='signUp'>Return to Sign Up Page</a></p>");
        } else {
            Customer customer = new Customer(username, password, nationalCode, UserType.CUSTOMER, 20000);
            ApplicationContext.getCustomerService().save(customer);
            filterChain.doFilter(servletRequest, servletResponse);
        }

        out.println(
                "</body>\n" +
                        "</html>"
        );
    }
}
