package Service;

import java.util.List;
import Model.Rider;

public interface RiderService {
    public List<String> rideHistory(Rider rider);
}