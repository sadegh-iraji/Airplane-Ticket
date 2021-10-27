package ir.maktab.flightticket.util;

import ir.maktab.flightticket.domain.User;

public class SecurityContext {

    public SecurityContext() {
    }

    private static User activeUser;

    public static void signOut() {
        activeUser = null;
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User activeUser) {
        SecurityContext.activeUser = activeUser;
    }

}

