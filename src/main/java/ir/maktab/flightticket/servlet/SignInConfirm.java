package ir.maktab.flightticket.servlet;

import ir.maktab.flightticket.domain.User;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = SecurityContext.getActiveUser();
        switch (user.getUserType()){
            case ADMIN:
                resp.sendRedirect("adminMain");
                break;
            case OPERATOR:
                resp.sendRedirect("operatorMain");
                break;
            case CUSTOMER:
                resp.sendRedirect("customerMain");
                break;
        }
    }
}
