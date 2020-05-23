package Controller;

import java.util.Scanner;
import Model.*;
import Service.*;

public class Controller {
    public static void main(String[] args) {
        LoginServiceImpl loginService = ServiceFactory.getLoginServiceImpl();
        DriverServiceImpl driverService = ServiceFactory.getDriverServiceImpl();
        CabServiceImpl cabService = ServiceFactory.getCabServiceImpl();

        Scanner in = new Scanner(System.in);
        Rider loggedInRider = null;
        Driver loggerInDriver = null;
        while(true) {
            System.out.println("/** MENU **/");
            System.out.println("1. Signup Rider");
            System.out.println("2. Signup Driver");
            System.out.println("3. Login Rider");
            System.out.println("4. Login Driver");
            System.out.println("5. Update Cab Location");
            System.out.println("6. Update availability");
            System.out.println("7. Book Ride");
            System.out.println("8. End Ride");

            int selection = Integer.MIN_VALUE;
            try {
                selection = Integer.parseInt(in.nextLine());
            }
            catch(Exception e) {
                selection = Integer.MIN_VALUE;
                System.out.println("Please enter a valid selection");
            }
                
            if(selection == 1) {
                Rider rider = new Rider();
                System.out.println("Please enter email");
                rider.getAccount().setEmail(in.nextLine());
                System.out.println("Please enter Name");
                rider.setName(in.nextLine());
                System.out.println("Please enter password");
                rider.getAccount().setPassword(in.nextLine());
                loginService.signUpRider(rider);
            }
            else if(selection == 2) {
                Driver driver = new Driver();
                System.out.println("Please enter email");
                driver.getAccount().setEmail(in.nextLine());
                System.out.println("Please enter Name");
                driver.setName(in.nextLine());
                System.out.println("Please enter Password");
                driver.getAccount().setPassword(in.nextLine());
                loginService.signUpDriver(driver);

                System.out.println("Please enter cab model");
                String cabModel = (in.nextLine());
                Cab cab = new Cab();
                cab.setModel(cabModel);
                driverService.assignCab(driver,cab);
                cabService.addCab(cab);
            }
            else if(selection == 3) {
                Rider rider = new Rider();
                System.out.println("Please enter email");
                rider.getAccount().setEmail(in.nextLine());
                System.out.println("Please enter password");
                rider.getAccount().setPassword(in.nextLine());
                Rider cus = loginService.loginRider(rider.getAccount().getEmail(), rider.getAccount().getPassword());
                if(cus != null) {
                    loggedInRider = cus;
                    System.out.println("Login successful, Name : " + cus.getName());
                }
                else {
                    loggedInRider = null;
                }
            }
            else if(selection == 4) {
                Driver rider = new Driver();
                System.out.println("Please enter email");
                rider.getAccount().setEmail(in.nextLine());
                System.out.println("Please enter password");
                rider.getAccount().setPassword(in.nextLine());
                Driver cus = loginService.loginDriver(rider.getAccount().getEmail(), rider.getAccount().getPassword());
                if(cus != null) {
                    loggerInDriver = cus;
                    System.out.println("Login successful, Name : " + cus.getName());
                }
                else {
                    loggerInDriver = null;
                }
            }
            else if(selection == 5) {
                if(loggerInDriver == null) {
                    System.out.println("please login in first");
                }
                System.out.println("Please enter new X");
                int x = (Integer.parseInt(in.nextLine()));
                System.out.println("Please enter new Y");
                int y = (Integer.parseInt(in.nextLine()));
                driverService.updateCabLocation(loggerInDriver, x, y);
                System.out.println("Cab location updated succesfully");
            }
            else if(selection == 6) {
                if(loggerInDriver == null) {
                    System.out.println("please login in first");
                }
                System.out.println("Please enter new Status");
                String status = (in.nextLine());
                driverService.updateAvailability(loggerInDriver, status);
                System.out.println("Availability updated succesfully");
            }
            else if(selection == 7) {
                if(loggedInRider == null) {
                    System.out.println("please login first");
                }
                Cab cab = cabService.bookCab(loggedInRider);
                if(cab == null) {
                    System.out.println("unable to book ride");
                } 
                else {
                    System.out.println("Cab booked succesfully, Model no : " + cab.getModel());
                }
            }
            else if(selection == 8) {
                if(loggerInDriver == null) {
                    System.out.println("please login first");
                }
                driverService.endRide(loggerInDriver);
            }
            else if (selection != Integer.MIN_VALUE){
                System.out.println("Thanks for using our services!");
                break;
            }
            System.out.println();
            System.out.println("===============");
        }
        in.close();
    }
}