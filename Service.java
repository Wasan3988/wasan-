package salonsystem;

public class Service {
    private double price;
    private String name;
    private ServiceCatalog serviceCatalog;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
        this.serviceCatalog = ServiceCatalog.getInstance();
    }

    Service(String name) {
        this(name, 0.0);
    }

    public boolean registerService() {
        return serviceCatalog.register(this);
    }

    public boolean updatePrice() {
        return serviceCatalog.update(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean removeService() {
        return serviceCatalog.remove(this);
    }

    public static Service findService(String name) {
        return ServiceCatalog.getInstance().find(name);
    }

}
