package salonsystem;

import java.util.List;

public class BookingInfo {
    private Integer reservationNumber;
    private Customer customer;
    private List<Service> services;// array list 
    private double totalPrice;
    private DayAndDate dayAndDate;

    public BookingInfo(Customer user, List<Service> services, DayAndDate dayAndDate, Integer reservationNumber) {
        this.customer = user;
        this.services = services;
        this.reservationNumber = reservationNumber;
        this.dayAndDate = dayAndDate;
        this.totalPrice = 0.0;
        this.totalPrice = getTotalPrice();
    }

    public double getTotalPrice() {
        if (this.totalPrice != 0.0)
            return this.totalPrice;

        for (Service service : services) {
            this.totalPrice += service.getPrice();
        }

        return this.totalPrice;
    }

    public static BookingInfo registers(Integer reservationNumber, Customer user, List<Service> services,DayAndDate dayAndDate) {
        return new BookingInfo(user, services, dayAndDate, reservationNumber);
    }

    @Override
    public String toString() {
        String str = "Customer :" + this.customer.getUsername() + "\n" +
                "reservation Number : " + this.reservationNumber.toString() + "\n" +
                "Total Price :" + this.totalPrice + "\n" +
                "Appointment Time : " + this.dayAndDate;
        return str;
    }

}
