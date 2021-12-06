package salonsystem;

public interface Accounts {

    String getUsername();

    String getPassword();

    boolean register();

    boolean login();

    boolean logout();

    boolean updateInfo(Customer customer);
}
