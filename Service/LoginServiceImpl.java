package Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import Model.*;


public class LoginServiceImpl implements LoginService {
    private Map<String, Customer> activeCustomers = new HashMap<String,Customer>();
    
    public boolean signUp(Customer customer) {
        if(!validateParams(customer)) {
            System.out.println("Invalid customer data.");
            return false;
        }
        if(activeCustomers.containsKey(customer.getEmail())) {
            System.out.println("Email is already registered for another user. Please use different email id");
            return false;
        }

        activeCustomers.put(customer.getEmail(), customer);
        System.out.println("Customer signed up succesfully : Name : " + customer.getName());
        return true;
    }

    public boolean validateParams(Customer customer) {
        if(customer.getEmail() == null || customer.getPassword() == null) {
            return false;
        }       
        return true;
    }

    public Customer login(String email, String password) {
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        if(!validateParams(customer)) {
            System.out.println("Invalid customer data.");
            return null;
        }

        if(!activeCustomers.containsKey(customer.getEmail())) {
            System.out.println("Email doesn't exist. Kindly sign up.");
            return null;
        }
        Customer systemCustomer = activeCustomers.get(customer.getEmail());
        if(!systemCustomer.getPassword().equals(password)) {
            System.out.println("Invalid credentials");
        }
        else {
            return systemCustomer;
        }
        return null;
    }


    public LoginServiceImpl() {
    }


    public LoginServiceImpl(Map<String,Customer> activeCustomers) {
        this.activeCustomers = activeCustomers;
    }

    public Map<String,Customer> getActiveCustomers() {
        return this.activeCustomers;
    }

    public void setActiveCustomers(Map<String,Customer> activeCustomers) {
        this.activeCustomers = activeCustomers;
    }

    public LoginServiceImpl activeCustomers(Map<String,Customer> activeCustomers) {
        this.activeCustomers = activeCustomers;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LoginServiceImpl)) {
            return false;
        }
        LoginServiceImpl loginServiceImpl = (LoginServiceImpl) o;
        return Objects.equals(activeCustomers, loginServiceImpl.activeCustomers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(activeCustomers);
    }

    @Override
    public String toString() {
        return "{" +
            " activeCustomers='" + getActiveCustomers() + "'" +
            "}";
    }

}