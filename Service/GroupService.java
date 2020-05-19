package Service;

import java.util.Collection;
import java.util.List;

import Model.*;

public interface GroupService {
    public Collection<Group> allGroups();
    public List<Group> getMyGroups(String username);
    public Group addLog(Customer customer, Double amount, String groupId);
    public boolean createGroup(Customer customer, String[] usernames, String groupName);
}