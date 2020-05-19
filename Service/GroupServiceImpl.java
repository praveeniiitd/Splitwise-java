package Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import Model.*;

public class GroupServiceImpl implements GroupService {
    private HashMap<String, Group> groups = new HashMap<String, Group>();
    private HashMap<String, List<Group>> customerGroup = new HashMap<String, List<Group>>();
    private LoginServiceImpl login;

    public Collection<Group> allGroups() {
        return groups.values();
    }

    public List<Group> getMyGroups(String username) {
        return customerGroup.get(username);
    }

    public Group addLog(Customer customer, Double amount, String groupId) {
        if (!groups.containsKey(groupId)) {
            System.out.println("Wrong group Id passed");
            return null;
        }

        List<Group> custGroups = customerGroup.get(customer.getEmail());
        boolean isPartOfGroup = false;
        for (Group gr : custGroups) {
            if (gr.getGroupId().equals(groupId)) {
                isPartOfGroup = true;
                break;
            }
        }

        if (!isPartOfGroup) {
            System.out.println("Wrong group Id passed");
            return null;
        }

        Group gr = groups.get(groupId);
        for (Customer c : gr.getGroupMembers()) {
            if (c.getEmail().equals(customer.getEmail())) {
                Double currentAmount = gr.getCustomerAmountStatus().get(c.getEmail());
                currentAmount = currentAmount + amount - (amount / gr.getGroupMembers().size());
                gr.getCustomerAmountStatus().put(c.getEmail(), currentAmount);
            } else {
                Double currentAmount = gr.getCustomerAmountStatus().get(c.getEmail());
                currentAmount = currentAmount - (amount / gr.getGroupMembers().size());
                gr.getCustomerAmountStatus().put(c.getEmail(), currentAmount);
            }
        }
        return gr;
    }

    public boolean createGroup(Customer customer, String[] usernames, String groupName) {
        Group group = new Group();

        List<Customer> members = new ArrayList<Customer>();
        for (String user : usernames) {
            if (!login.getActiveCustomers().containsKey(user)) {
                System.out.println("Provided customer username not valid");
                return false;
            }

            if (customer.getEmail().equals(user)) {
                System.out.println("Own email cannot be passed");
                return false;
            }
            members.add(login.getActiveCustomers().get(user));
            group.getCustomerAmountStatus().put(user, 0.0);
        }
        members.add(customer);

        group.setGroupId("" + (allGroups().size() + 1));
        group.setGroupMembers(members);
        group.setName(groupName);
        group.setStatus("ACTIVE");
        group.getCustomerAmountStatus().put(customer.getEmail(), 0.0);

        groups.put(group.getGroupId(), group);
        List<Group> gr = customerGroup.getOrDefault(customer.getEmail(), new ArrayList<Group>());
        gr.add(group);
        customerGroup.put(customer.getEmail(), gr);
        return true;
    }

    public GroupServiceImpl() {
        this.login = ServiceFactory.getLoginServiceImpl();
    }

    public GroupServiceImpl(LoginServiceImpl loginService) {
        this.login = loginService;
    }

    public GroupServiceImpl(HashMap<String, Group> groups) {
        this.groups = groups;
    }

    public HashMap<String, Group> getGroups() {
        return this.groups;
    }

    public void setGroups(HashMap<String, Group> groups) {
        this.groups = groups;
    }

    public GroupServiceImpl groups(HashMap<String, Group> groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GroupServiceImpl)) {
            return false;
        }
        GroupServiceImpl groupService = (GroupServiceImpl) o;
        return Objects.equals(groups, groupService.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(groups);
    }

    @Override
    public String toString() {
        return "{" +
            " groups='" + getGroups() + "'" +
            "}";
    }
}