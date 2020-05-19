package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Group {
    private List<Customer> groupMembers = new ArrayList<Customer>();
    private HashMap<String,Double> customerAmountStatus = new HashMap<String,Double>();
    private String groupId;
    private String status;
    private String name;

    public Group() {
    }

    public Group(List<Customer> groupMembers, String groupId, String status, String name) {
        this.groupMembers = groupMembers;
        this.groupId = groupId;
        this.status = status;
        this.name = name;

        for(Customer c : groupMembers) {
            customerAmountStatus.put(c.getEmail(), 0.0);
        }
    }

    public List<Customer> getGroupMembers() {
        return this.groupMembers;
    }

    public void setGroupMembers(List<Customer> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group groupMembers(List<Customer> groupMembers) {
        this.groupMembers = groupMembers;
        return this;
    }

    public Group groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Group status(String status) {
        this.status = status;
        return this;
    }

    public Group name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Group)) {
            return false;
        }
        Group group = (Group) o;
        return Objects.equals(groupMembers, group.groupMembers) && Objects.equals(groupId, group.groupId) && Objects.equals(status, group.status) && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupMembers, groupId, status, name);
    }

    @Override
    public String toString() {
        return "{" +
            " groupMembers='" + getGroupMembers() + "'" +
            ", groupId='" + getGroupId() + "'" +
            ", status='" + getStatus() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

    public Group(List<Customer> groupMembers, HashMap<String,Double> customerAmountStatus, String groupId, String status, String name) {
        this.groupMembers = groupMembers;
        this.customerAmountStatus = customerAmountStatus;
        this.groupId = groupId;
        this.status = status;
        this.name = name;
    }

    public HashMap<String,Double> getCustomerAmountStatus() {
        return this.customerAmountStatus;
    }

    public void setCustomerAmountStatus(HashMap<String,Double> customerAmountStatus) {
        this.customerAmountStatus = customerAmountStatus;
    }

    public Group customerAmountStatus(HashMap<String,Double> customerAmountStatus) {
        this.customerAmountStatus = customerAmountStatus;
        return this;
    }
}