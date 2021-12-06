package salonsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    private List<Customer> customers;
    private List<CustomerStatus> status;
    private static UserManager instance = null;

    private UserManager() {
        this.customers = new ArrayList<>();
        this.status = new ArrayList<>();
    }

    public static UserManager getInstance() {//??
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public Customer getCustomerByUserName(String username) {
        List<Customer> temp = customers.stream().filter(c -> c.getUsername().equals(username)).collect(Collectors.toList());//???
        if (temp.size() == 0)
            return null;
        return temp.get(0);
    }

    public boolean findUser(String username) {
        return this.getCustomerByUserName(username) != null;
    }

    private boolean validateUser(Customer customer) {//???
        return !customer.getUsername().equals("") && !customer.getUsername().equals("");
    }

    public boolean addUser(Customer customer) {
        if (validateUser(customer)) {
            customers.add(customer);
            status.add(CustomerStatus.LOGOUT);
            return true;
        }
        return false;
    }

    public Customer login(Customer user) {
        int i = 0;
        for (Customer customer : customers) {
            if (customer.getUsername().equals(user.getUsername())) {
                if (user.getPassword().equals(user.getPassword())) {
                    status.set(i, CustomerStatus.LOGIN);
                    return customer;
                }
            }
            i++;
        }
        return null;///???
    }

    public boolean logout(Customer user) {

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUsername().equals(user.getUsername())) {
                if (status.get(i) == CustomerStatus.LOGIN) {
                    status.set(i, CustomerStatus.LOGOUT);
                    return true;
                } else
                    return false;
            }
        }
        return false;
    }

    public boolean updateInfo(Customer user) {

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getUsername().equals(user.getUsername()) && customer.getPassword().equals(user.getPassword())
                    && status.get(i) == CustomerStatus.LOGIN) {///???/
                customers.remove(i);
                customers.add(user);///????
                status.remove(i);
                status.add(CustomerStatus.LOGIN);
                return true;
            }
        }
        return false;

    }

}