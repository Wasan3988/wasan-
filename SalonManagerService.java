package salonsystem;

import java.util.Map;
import java.util.HashMap;

public class SalonManagerService {
    private Map<String, Salon> salons; 
    private static SalonManagerService instance = null;

    private SalonManagerService() {
        salons = new HashMap<>();
    }

    public static SalonManagerService getInstance() {
        if (instance == null)
            instance = new SalonManagerService();
        return instance;
    }

    public int getID() {
        return salons.size() + 1;
    }

    public boolean registerSalon(Salon salon) {
        if (findByName(salon.getName()) == null) {
            salons.put(salon.getName(), salon);
            return true;
        }
        return false;
    }

    public boolean removeSalon(String name) {
        if (findByName(name) == null)
            return false;
        salons.remove(name);
        return true;
    }

    public Salon findByName(String name) {
        return salons.getOrDefault(name, null);
    }
}
