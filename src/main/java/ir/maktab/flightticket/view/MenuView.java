package ir.maktab.flightticket.view;

public class MenuView {

    public static void signUpOrSignIn(){
        System.out.println(
                "1. Customer Sign Up\n" +
                        "2. Sign In\n" +
                        "3. Exit"
        );
    }

    public static void adminMenuView(){
        System.out.println(
                "1. Add Airline\n" +
                        "2. Add Operator\n" +
                        "3. Edit Operator's Airline\n" +
                        "4. Remove Airline\n" +
                        "5. Sign Out"
        );
    }

    public static void operatorMenuView(){
        System.out.println(
                "1. View and Edit your profile\n" +
                        "2. View tickets of your airline\n" +
                        "3. Add a ticket for your airline\n" +
                        "4. Sign Out"
        );
    }

    public static void customerMenuView(){
        System.out.println(
                "1. View and Edit your profile\n" +
                        "2. Reserve a ticket\n" +
                        "3. View your reserved tickets\n" +
                        "4. Sign Out"
        );
    }

    public static void editOperatorMenuView(){
        System.out.println(
                "1. Edit Your Username\n" +
                        "2. Edit Your Password\n" +
                        "3. Back to view or edit profile menu"
        );
    }

    public static void sortOrReserveTicketMenuView(){
        System.out.println(
                "1. Sort tickets\n" +
                        "2. Reserve a ticket\n" +
                        "3. Back to ticket menu"
        );
    }

    public static void sortTicketMenuView() {
        System.out.println(
                "1. Sort by Price\n" +
                        "2. Sort by Airline\n" +
                        "3. Sort by Origin\n" +
                        "4. Sort by Destination\n" +
                        "5. Sort By Date" +
                        "6. Back to sort or reserve menu"
        );
    }

    public static void showAscDescInSortMenu() {
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
    }
}
