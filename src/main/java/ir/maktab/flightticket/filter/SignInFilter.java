package ir.maktab.flightticket.filter;

import ir.maktab.flightticket.domain.User;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <link rel='stylesheet' href='resource/styles/style.css'>\n" +
                        "</head>\n" +
                        "<body>\n"
        );

        if (!ApplicationContext.getUserRepository().existUserByUsernameAndPassword(username, password)) {
            out.println(
                    "<h2 align='center'> ----> Wrong Username or Password <---- </h2>\n" +
                            "<p align='center'><a href='signIn'>Return to Sign In Page</a></p><br>" +
                            "<p align='center'>If you don't have an Account you can <a href='signUp'>Sign Up</a></p>");
        } else {
            User user = ApplicationContext.getUserService().findUserByUsername(username);
            SecurityContext.setActiveUser(user);
            filterChain.doFilter(servletRequest, servletResponse);
        }

        out.println(
                "</body>\n" +
                        "</html>"
        );
    }
}
