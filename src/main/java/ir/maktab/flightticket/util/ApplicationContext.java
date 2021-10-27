package ir.maktab.flightticket.util;

import ir.maktab.flightticket.repository.*;
import ir.maktab.flightticket.repository.impl.*;
import ir.maktab.flightticket.service.*;
import ir.maktab.flightticket.service.impl.*;

import javax.persistence.EntityManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationContext {

    private static final AdminRepository adminRepository;
    private static final AdminService adminService;

    static {
        EntityManager adminManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        adminRepository = new AdminRepositoryImpl(adminManager);
        adminService = new AdminServiceImpl(adminRepository);
    }

    private static final AirlineRrpository airlineRrpository;
    private static final AirlineService airlineService;

    static {
        EntityManager airlineManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        airlineRrpository = new AirlineRepositoryImpl(airlineManager);
        airlineService = new AirlineServiceImpl(airlineRrpository);
    }

    private static final CustomerRepository customerRepository;
    private static final CustomerService customerService;

    static {
        EntityManager customerManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        customerRepository = new CustomerRepositoryImpl(customerManager);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    private static final OperatorRepository operatorRepository;
    private static final OperatorService operatorService;

    static {
        EntityManager operatorManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        operatorRepository = new OperatorRepositoryImpl(operatorManager);
        operatorService = new OperatorServiceImpl(operatorRepository);
    }

    private static final TicketRepository ticketRepository;
    private static final TicketService ticketService;

    static {
        EntityManager ticketManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        ticketRepository = new TicketRepositoryImpl(ticketManager);
        ticketService = new TicketServiceImpl(ticketRepository);
    }

    private static final UserRepository userRepository;
    private static final UserService userService;

    static {
        EntityManager userManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        userRepository = new UserRepositoryImpl(userManager);
        userService = new UserServiceImpl(userRepository);
    }

    private static final CouponRepository couponRepository;
    private static final CouponService couponService;

    static {
        EntityManager couponManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        couponRepository = new CouponRepositoryImpl(couponManager);
        couponService = new CouponServiceImpl(couponRepository);
    }

    public static CouponRepository getCouponRepository() {
        return couponRepository;
    }

    public static CouponService getCouponService() {
        return couponService;
    }

    private static final Scanner textScanner = new Scanner(System.in);

    private static final Scanner numericScanner = new Scanner(System.in);

    public static AdminRepository getAdminRepository() {
        return adminRepository;
    }

    public static AdminService getAdminService() {
        return adminService;
    }

    public static AirlineRrpository getAirlineRrpository() {
        return airlineRrpository;
    }

    public static AirlineService getAirlineService() {
        return airlineService;
    }

    public static CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static OperatorRepository getOperatorRepository() {
        return operatorRepository;
    }

    public static OperatorService getOperatorService() {
        return operatorService;
    }

    public static TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public static TicketService getTicketService() {
        return ticketService;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static Scanner getTextScanner() {
        return textScanner;
    }

    public static Scanner getNumericScanner() {
        return numericScanner;
    }

    public static int intFromScannerReturn(int number) {
        do {
            try {
                number = getNumericScanner().nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter an Integer Number !");
                getNumericScanner().next();
            }
        } while (number < 1);
        return number;
    }

    public static long longFromScannerReturn(long number) {
        do {
            try {
                number = ApplicationContext.getNumericScanner().nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Long Number !");
                ApplicationContext.getNumericScanner().next();
            }
        } while (number < 1);
        return number;
    }

    public static double doubleFromScanner(double number){
        do {
            try {
                number = ApplicationContext.getNumericScanner().nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Double Number !");
                ApplicationContext.getNumericScanner().next();
            }
        } while (number < 1);
        return number;
    }

}
