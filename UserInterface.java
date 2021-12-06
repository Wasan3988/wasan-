package intraction;

import salonsystem.*;
import java.util.*;
import java.io.*;

public class UserInterface {
    private BufferedReader in;
    private Customer currentUser;
    private List<Service> cart;

    public UserInterface(Customer user) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        currentUser = user;
        cart = new ArrayList<>();
    }

    public void userMenu() throws IOException {
        String str = "1. Make Booking \n2. logout";
        System.out.println("Hi, " + currentUser.getUsername() + "\n");
        loop: while (true) {
            System.out.println(str);
            String temp = in.readLine();
            int ch = Integer.parseInt(temp.equals("") ? "0" : temp);

            switch (ch) {
                case 1:
                    createBooking();
                    break;

                case 2:
                    currentUser.logout();
                    break loop;
            }

        }
    }

    public void createBooking() throws IOException {

        System.out.println("Select Salon : ");
        Salon salon = Salon.findSalon(in.readLine().trim());

        if (salon == null) {
            System.out.println("Salon does not Exits");
            return;
        }

        while (true) {
            System.out.println("1. Add Service \n2. Continue\n");
            int ch = Integer.parseInt(in.readLine());
            if (ch == 2)
                break;
            if (ch != 1)
                continue;
            System.out.println("Enter Service Name");
            Service service = Service.findService(in.readLine().trim());
            if (service == null) {
                System.out.println("Service Does not Exists !! ");
                continue;
            }
            cart.add(service);//array list 
        }

        System.out.println("Add date and time"+"\n");

        System.out.println("Enter date: ");
        DayAndDate dnd = new DayAndDate();// object dnd= day and date 
        dnd.setDate(in.readLine());
        
        System.out.println("Enter time: ");
        dnd.setDay(in.readLine());

        int rno = (int) (Math.random() * 10000);//service number 

        BookingInfo booking = new BookingInfo(currentUser, cart, dnd, rno);

        System.out.println(booking);

        System.out.println("Payment methods...");
        Paying pay = new Paying(booking);

        System.out.println("Enter payment Method : ");
        System.out.println("You wish to pay on arrival [y/n] : ");
        char ch = (char) in.read();
        boolean payOnArrival = true;

        String cardName = "";
        int cardNumber = 0, cvv = 0, day = 0, date = 0;

        if (ch != 'y') {
            payOnArrival = false;
            System.out.println("Enter Name on Card : ");
            in.readLine();
            cardName = in.readLine();
            System.out.println("Enter card Number : ");
            cardNumber = Integer.parseInt(in.readLine());
            System.out.println("Enter CVV : ");
            cvv = Integer.parseInt(in.readLine());
            System.out.println("Enter Expiry Day : ");
            day = Integer.parseInt(in.readLine());
            System.out.println("Enter Expiry year : ");
            date = Integer.parseInt(in.readLine());
        }

        pay.registers(payOnArrival, "card", cardNumber, cardName, cvv, day, date); // call object pay 

        System.out.println(pay);
        System.out.println("Appointment Confirmed in " + salon.getName()+" !!");
    }
}
