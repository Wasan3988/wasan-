package salonsystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ServiceCatalog {
    private Map<String, Service> services;
    private static ServiceCatalog instance = null;

    private ServiceCatalog() {
        this.services = new HashMap<>();///????
    }

    public static ServiceCatalog getInstance() {
        if (instance == null)
            instance = new ServiceCatalog();

        return instance;
    }

    public Collection<Service> getAllServices() {
        return services.values();
    }

    public Service find(String name) {
        return services.getOrDefault(name, null);
    }

    public boolean register(Service service) {
        if (find(service.getName()) == null) {
            services.put(service.getName(), service);
            return true;
        }
        return false;
    }

    public boolean remove(Service service) {
        if (find(service.getName()) == null)
            return false;
        services.remove(service.getName());
        return true;
    }

    public boolean update(Service service) {
        if (remove(service) && register(service))
            return true;
        return false;
    }

}
