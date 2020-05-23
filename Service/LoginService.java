package Service;

import Model.*;

public interface LoginService {
    public boolean signUpDriver(Driver driver);
    public boolean signUpRider(Rider rider);
    public Rider loginRider(String email, String password);
    public Driver loginDriver(String email, String password);
}