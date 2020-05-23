package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Model.Cab;
import Model.Driver;

public class DriverServiceImpl implements DriverService {
    private HashMap<String, List<Cab>> driverCab = new HashMap<String, List<Cab>>();
    
    public List<Cab> getMyCab(Driver driver) {
        String email = driver.getAccount().getEmail();
        if(!driverCab.containsKey(email)) {
            System.out.println("no cabs associated with the driver");
            return null;
        }
        return driverCab.get(email);
    }

    public boolean assignCab(Driver driver, Cab cab) {
        List<Cab> cabs = driverCab.getOrDefault(driver.getAccount().getEmail(), new ArrayList<Cab>());
        cabs.add(cab);
        driverCab.put(driver.getAccount().getEmail(), cabs);
        return true;
    }

    @Override
    public boolean updateCabLocation(Driver driver, int x, int y) {
        String email = driver.getAccount().getEmail();
        if(!driverCab.containsKey(email)) {
            System.out.println("no cabs associated with driver");
            return false;
        }

        List<Cab> cabs = driverCab.get(driver.getAccount().getEmail());
        if(cabs.size() == 0) {
            System.out.println("no cabs associated with driver");
            return false;
        }

        Cab cab = cabs.get(0);
        cab.setLocationX(x);
        cab.setLocationY(y);
        return true;
    }

    @Override
    public boolean updateAvailability(Driver driver, String status) {
        driver.setAvailability(status);
        return false;
    }

    @Override
    public boolean endRide(Driver driver) {
        String email = driver.getAccount().getEmail();
        if(!driverCab.containsKey(email)) {
            System.out.println("no cabs with driver");
            return false;
        }
        List<Cab> cabs = driverCab.get(email);
        Cab cab = null;
        for(Cab c : cabs) {
            if(c.getStatus() == "B") {
                c.setStatus("A");
                cab = c;
            }
        }
        if(cab == null) {
            System.out.println("no running cabs with driver");
        }
        else 
            System.out.println("Ride ended succesfuly for cab with model no " + cab.getModel());
        return true;
    }
}