package Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Model.*;

public class CabServiceImpl implements CabService {
    private HashMap<String, Cab> cabs = new HashMap<String, Cab>();
    private HashMap<String,Cab> riderCab = new HashMap<String,Cab>();
    private HashMap<String,List<String>> riderHistory = new HashMap<String,List<String>>();

    @Override
    public Collection<Cab> allCabs() {
        return cabs.values();
    }

    @Override
    public Cab bookCab(Rider rider) {
        Cab cab = null;
        for(Cab c : cabs.values()) {
            if(c.getStatus().equals("A")) {
                if( Math.abs(c.getLocationX() - rider.getLocationX()) < 2 && Math.abs(c.getLocationY() - rider.getLocationY()) < 2) {
                    cab = c;
                    cab.setStatus("B");
                    riderCab.put(rider.getAccount().getEmail(), cab);
                    break;
                }
            }
        }
        return cab;
    }

    @Override
    public boolean addCab(Cab cab) {
        String id = (cabs.size() + 1) + "";
        cab.setCabId(id);
        cab.setStatus("A");
        cabs.put(id, cab);
        return true;
    }
}