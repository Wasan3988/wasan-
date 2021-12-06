package salonsystem;

public class Salon {
    private String name;
    private String address;
    private SalonManagerService salonManager;

    public Salon(String name, String address) {
        this.salonManager = SalonManagerService.getInstance();
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean registerSalon() {
        return salonManager.registerSalon(this);
    }

    public boolean removeSalon() {
        return salonManager.removeSalon(this.name);
    }

    public static Salon findSalon(String name) {
        return SalonManagerService.getInstance().findByName(name);
    }

}
