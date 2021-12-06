package salonsystem;

public class Customer implements Accounts {
    String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String customerName;
    private UserManager userManager;

    public Customer(String username, String password, String phoneNumber, String address, String customerName) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerName = customerName;
        this.userManager = UserManager.getInstance();
    }

    public Customer(String username, String password) {
        this(username, password, "", "", "");
    }

    Customer(Customer customer) {
        copy(customer);
    }

    private void copy(Customer user) {

        this.username = user.username;
        this.password = user.password;
        this.phoneNumber = user.phoneNumber;
        this.address = user.address;
        this.customerName = user.customerName;
        this.userManager = user.userManager;

    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean register() {

        if (userManager.findUser(this.username)) {
            return false;
        }

        return userManager.addUser(this);
    }

    @Override
    public boolean login() {

        if (!userManager.findUser(this.username))
            return false;

        Customer user = userManager.login(this);
        this.copy(user);
        return true;
    }

    @Override
    public boolean updateInfo(Customer updatedInfo) {
        updatedInfo.username = this.username;
        updatedInfo.password = this.password;
        return userManager.updateInfo(updatedInfo);
    }

    @Override
    public boolean logout() {
        return this.userManager.logout(this);
    }

    public static Customer getCustomerByUserName(String username) {
        return UserManager.getInstance().getCustomerByUserName(username);
    }

    @Override
    public String toString() {
        return this.username;
    }
}