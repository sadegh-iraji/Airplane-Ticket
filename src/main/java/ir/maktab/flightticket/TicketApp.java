package ir.maktab.flightticket;

import ir.maktab.flightticket.domain.Admin;
import ir.maktab.flightticket.domain.User;
import ir.maktab.flightticket.domain.enumetarion.UserType;
import ir.maktab.flightticket.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class TicketApp {
    public static void main(String[] args) {


//        LocalTime time = LocalTime.parse("17:50:00");

////
//        System.out.println(LocalTime.parse("16:40:00").compareTo(LocalTime.parse("13:40:00")));
//        System.out.println(Duration.between(LocalTime.parse("16:20:00"), LocalTime.parse("16:40:00")).toMinutes());
//
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("TicketUnit");
        EntityManager adminManager = entityManagerFactory.createEntityManager();
        adminManager.getTransaction().begin();
        Admin admin = new Admin("admin", "admin", "3240782375", UserType.ADMIN);
        adminManager.persist(admin);
        adminManager.getTransaction().commit();
    }
}
