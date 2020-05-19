package Service;

import Model.Customer;

public interface LoginService {
    public boolean signUp(Customer customer);
    public Customer login(String email, String password);
}