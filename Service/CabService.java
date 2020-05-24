

import java.util.Collection;

public interface CabService {
    public Collection<Cab> allCabs();
    public boolean addCab(Cab cab);
    public Cab bookCab(Rider rider);
}