package Service;

import java.util.HashMap;
import java.util.Map;

import Model.*;


public class LoginServiceImpl implements LoginService {
    private Map<String, Rider> activeRiders = new HashMap<String,Rider>();
    private Map<String, Driver> activeDrivers = new HashMap<String,Driver>();
    
    public boolean signUpRider(Rider rider) {
        if(!validateParams(rider.getAccount())) {
            System.out.println("Invalid login credentials provided.");
            return false;
        }
        if(activeRiders.containsKey(rider.getAccount().getEmail())) {
            System.out.println("Email is already registered for another user. Please use different email id");
            return false;
        }

        activeRiders.put(rider.getAccount().getEmail(), rider);
        System.out.println("Rider signed up succesfully : Name : " + rider.getName());
        return true;
    }

    public boolean signUpDriver(Driver driver) {
        if(!validateParams(driver.getAccount())) {
            System.out.println("Invalid login credentials provided.");
            return false;
        }
        if(activeDrivers.containsKey(driver.getAccount().getEmail())) {
            System.out.println("Email is already registered for another user. Please use different email id");
            return false;
        }

        activeDrivers.put(driver.getAccount().getEmail(), driver);
        System.out.println("Driver signed up succesfully : Name : " + driver.getName());
        return true;
    }

    public boolean validateParams(Account account) {
        if(account.getEmail() == null || account.getPassword() == null) {
            return false;
        }       
        return true;
    }

    public Rider loginRider(String email, String password) {
        Rider rider = new Rider();
        rider.getAccount().setEmail(email);
        rider.getAccount().setPassword(password);
        if(!validateParams(rider.getAccount())) {
            System.out.println("Invalid credentials");
            return null;
        }

        if(!activeRiders.containsKey(rider.getAccount().getEmail())) {
            System.out.println("Email doesn't exist. Kindly sign up.");
            return null;
        }
        rider = activeRiders.get(email);
        if(!rider.getAccount().getPassword().equals(password)) {
            System.out.println("Invalid credentials");
        }
        else {
            return rider;
        }
        return null;
    }

    public Driver loginDriver(String email, String password) {
        Driver driver = new Driver();
        driver.getAccount().setEmail(email);
        driver.getAccount().setPassword(password);
        if(!validateParams(driver.getAccount())) {
            System.out.println("Invalid credentials");
            return null;
        }

        if(!activeDrivers.containsKey(driver.getAccount().getEmail())) {
            System.out.println("Email doesn't exist. Kindly sign up.");
            return null;
        }
        driver = activeDrivers.get(email);
        if(!driver.getAccount().getPassword().equals(password)) {
            System.out.println("Invalid credentials");
        }
        else {
            return driver;
        }
        return null;
    }

    public LoginServiceImpl() {
    }
}