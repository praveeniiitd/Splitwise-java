package Service;

public class ServiceFactory {
    private static CustomerServiceImpl customerService;
    private static GroupServiceImpl groupService;
    private static LoginServiceImpl loginService;
    
    public static CustomerServiceImpl getCustomerServiceImpl() {
        if(customerService == null) {
            customerService = new CustomerServiceImpl();
        }
        return customerService;
    } 

    public static GroupServiceImpl getGroupServiceImpl() {
        if(groupService == null) {
            groupService = new GroupServiceImpl();
        }
        return groupService;
    } 

    public static LoginServiceImpl getLoginServiceImpl() {
        if(loginService == null) {
            loginService = new LoginServiceImpl();
        }
        return loginService;
    } 
}