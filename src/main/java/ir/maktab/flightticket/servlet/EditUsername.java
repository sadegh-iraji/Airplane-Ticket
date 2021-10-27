package ir.maktab.flightticket.servlet;

import ir.maktab.flightticket.domain.User;
import ir.maktab.flightticket.util.ApplicationContext;
import ir.maktab.flightticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        User user = SecurityContext.getActiveUser();

        String username = req.getParameter("username");

        user.setUsername(username);

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
            ApplicationContext.getUserService().save(user);
            out.println("<h2 align='center'> *** Your Username successfully *** </h2>");
        } catch (Exception e){
            e.printStackTrace();
            out.println("<h2 align='center'> ====> Something Wrong <==== </h2>");
        }

        out.println(
                "    <p>\n" +
                        "        <a href='signOut' class='underline'>Sign In Again</a>\n" +
                        "    </p>\n" +
                        "</body>\n" +
                        "</html>"
        );


    }
}
