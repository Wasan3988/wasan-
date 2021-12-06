package intraction;

import java.io.*;
import java.util.ArrayList;

import salonsystem.*;

public class Interface {

    private BufferedReader in;

    public Interface() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public void IntroMenu() throws IOException {
        String str = "1. Register Salon \n2. Update Salon Info. \n3. Remove Salon \n4. Add Services \n5. Show Services \n6. Register User \n7. Login User \n8. Exit";

        loop: while (true) {////????
            System.out.println(str);
            int ch = Integer.parseInt(in.readLine());////??
            switch (ch) {
                case 1:
                    registerSalon();
                    break;

                case 2:
                    updateSalonInfo();
                    break;

                case 3:
                    removeSalon();
                    break;

                case 4:
                    addService();
                    break;

                case 5:
                    showAllServices();
                    break;

                case 6:
                    registerUser();
                    break;
                case 7:
                    loginUser();
                    break;
                default:
                    break loop;
            }
        }
    }

    public void registerSalon() throws IOException {

        System.out.println("Enter Salon Name : ");
        String name = in.readLine();
        System.out.println("Enter Salon Address : ");
        String address = in.readLine();

        Salon salon = new Salon(name, address);

        salon.registerSalon();//

    }

    public void updateSalonInfo() throws IOException {

        System.out.println("Enter old Name : ");
        String old = in.readLine();
        System.out.println("Enter new Name : ");
        String newName = in.readLine();
        System.out.println("Enter address : ");
        String address = in.readLine();

        Salon salon = Salon.findSalon(old);//??

        if (salon == null) {//
            System.out.println("This Salon does not Exists !!");
            return;
        }

        salon.removeSalon();

        salon = new Salon(newName, address);

        salon.registerSalon();// new register
    }

    public void removeSalon() throws IOException {
        System.out.println("Enter Salon Name : ");
        String name = in.readLine();

        Salon salon = Salon.findSalon(name);// 

        if (salon == null) {
            System.out.println("This Salon Does not Exits !!\n");
            return;
        }

        salon.removeSalon();
    }

    public void addService() throws IOException {
        System.out.println("Enter Service Name : ");
        String name = in.readLine();

        System.out.println("Enter Price : ");
        double price = Double.parseDouble(in.readLine());//???

        Service service = new Service(name, price);

        service.registerService();

    }

    public void showAllServices() {
        new ArrayList<>(ServiceCatalog.getInstance().getAllServices())
                .forEach(s -> System.out.println(s.getName() + " " + s.getPrice() + "\n"));//????
    }

    public void registerUser() throws IOException {
        System.out.println("Enter Name : ");
        String name = in.readLine();
        System.out.println("Enter UserName : ");
        String username = in.readLine();
        System.out.println("Enter password : ");
        String password = in.readLine();
        System.out.println("Enter address : ");
        String address = in.readLine();
        System.out.println("Enter phone Number : ");
        String phoneNumber = in.readLine();

        Customer customer = new Customer(username, password, phoneNumber, address, name);

        if (customer.register()) {
            System.out.println("**** Successfully Registered !! ****" + "\n");
            
        }
        else
            System.out.println(" Some Error Occured !! ");
    }

    public void loginUser() throws IOException {
        System.out.println("Enter username : ");
        String name = in.readLine();
        System.out.println("Enter password : ");
        String password = in.readLine();

        Customer user = new Customer(name, password);
        if (user.login()) {
            System.out.println("**** Successfully Loged In !! ****" + "\n");
           
            new UserInterface(user).userMenu();
        } else
            System.out.println("Some Error has Occured !!");

    }

}
