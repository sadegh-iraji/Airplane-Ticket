package ir.maktab.flightticket.servlet.adminservlets;

import ir.maktab.flightticket.domain.Coupon;
import ir.maktab.flightticket.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class NewCouponConfirm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String code = req.getParameter("code");
        double discountPercent = Double.parseDouble(req.getParameter("discountPercent"));
        LocalDate expireDate = LocalDate.parse(req.getParameter("expireDate"));

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
            Coupon coupon = new Coupon(code,discountPercent, expireDate);
            ApplicationContext.getCouponService().save(coupon);
            out.println("<h2 align='center'> *** Coupon added successfully *** </h2>");
        } catch (Exception e) {
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
