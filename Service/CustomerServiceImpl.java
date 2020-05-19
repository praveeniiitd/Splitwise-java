package Service;

public class CustomerServiceImpl implements CustomerService{
    private GroupServiceImpl groupService;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }
}