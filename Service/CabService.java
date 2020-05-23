package Service;

import java.util.Collection;

import Model.*;

public interface CabService {
    public Collection<Cab> allCabs();
    public boolean addCab(Cab cab);
    public Cab bookCab(Rider rider);
}