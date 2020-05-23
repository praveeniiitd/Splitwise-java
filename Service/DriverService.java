package Service;

import java.util.List;
import Model.*;

public interface DriverService {
    public List<Cab> getMyCab(Driver driver);
    public boolean updateCabLocation(Driver driver, int x, int y);
    public boolean updateAvailability(Driver driver, String status);
    public boolean endRide(Driver driver);
}