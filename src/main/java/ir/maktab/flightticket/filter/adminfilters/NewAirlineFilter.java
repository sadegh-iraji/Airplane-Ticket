package ir.maktab.flightticket.filter.adminfilters;

import ir.maktab.flightticket.domain.Airline;
import ir.maktab.flightticket.util.ApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewAirlineFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String name = servletRequest.getParameter("name");

        if (!name.isEmpty()) {
            Airline airline = new Airline(name);
            ApplicationContext.getAirlineService().save(airline);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            out.println("<h2 align='center'> =====>Entered Nothing<==== </h2><br>");
            httpServletResponse.sendRedirect("newAirline");
        }
    }
}
