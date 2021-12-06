package salonsystem;

public class Paying {
    private double totalPrice;
    private boolean payOnArrival;
    private String nameOfPaymentMethod;
    private String cardName;
    private int cardNumber;
    private int securityCode;
    private int cardExpiryDay;
    private int yearCardExpiry;

    public Paying(BookingInfo bookingInfo) {
        this.totalPrice = bookingInfo.getTotalPrice();
    }

    public void registers(boolean payOnArrival, String nameOfPaymentMethod,
            int cardNumber, String cardName, int securityCode, int cardExpiryDay, int yearCardExpiry) {

        this.payOnArrival = payOnArrival;
        this.nameOfPaymentMethod = nameOfPaymentMethod;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.cardExpiryDay = cardExpiryDay;
        this.yearCardExpiry = yearCardExpiry;

    }

    public void updatedInfo(boolean payOnArrival, String nameOfPaymentMethod,
            int cardNumber, String cardName, int securityCode, int cardExpiryDay, int yearCardExpiry) {
        this.payOnArrival = payOnArrival;
        this.nameOfPaymentMethod = nameOfPaymentMethod;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.cardExpiryDay = cardExpiryDay;
        this.yearCardExpiry = yearCardExpiry;
    }

    @Override
    public String toString() {
        String str = (payOnArrival ? "Pay on Arrival" : "") + "\n" +
                "Payment Method : " + nameOfPaymentMethod + "\n" +
                "Name on Card : " + cardName + "\n" +
                "card Number : " + cardNumber + "\n" +
                "Security Code : " + securityCode + "\n" +
                "card Expiry Day : " + cardExpiryDay + "\n " +
                "year Expiry :" + yearCardExpiry + "\n" +
                "Total Price : " + totalPrice + "\n";
        return str;
    }

}
