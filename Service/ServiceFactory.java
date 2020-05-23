package Service;

public class ServiceFactory {
    private static LoginServiceImpl loginService;
    private static CabServiceImpl cabService;
    private static DriverServiceImpl driverService;

    public static LoginServiceImpl getLoginServiceImpl() {
        if(loginService == null) {
            loginService = new LoginServiceImpl();
        }
        return loginService;
    } 

    public static CabServiceImpl getCabServiceImpl() {
        if(cabService == null) {
            cabService = new CabServiceImpl();
        }
        return cabService;
    }

    public static DriverServiceImpl getDriverServiceImpl() {
        if(driverService == null) {
            driverService = new DriverServiceImpl();
        }
        return driverService;
    }

}