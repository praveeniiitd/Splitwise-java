package Controller;

import java.util.Scanner;
import Model.*;
import Service.*;

public class Controller {
    public static void main(String[] args) {
        LoginServiceImpl loginService = ServiceFactory.getLoginServiceImpl();
        //CustomerServiceImpl customerService = ServiceFactory.getCustomerServiceImpl();
        GroupServiceImpl groupService = ServiceFactory.getGroupServiceImpl();

        Scanner in = new Scanner(System.in);
        Customer loggedInuser = null;
        while(true) {
            System.out.println("/** MENU **/");
            System.out.println("1. Add Customer");
            System.out.println("2. Login with a Customer");
            System.out.println("3. Create sample customers");
            System.out.println("4. Create Group with logged in user");
            System.out.println("5. Get my groups");
            System.out.println("6. Add logs");

            int selection = Integer.MIN_VALUE;
            try {
                selection = Integer.parseInt(in.nextLine());
            }
            catch(Exception e) {
                selection = Integer.MIN_VALUE;
                System.out.println("Please enter a valid selection");
            }
                
            if(selection == 1) {
                Customer customer = new Customer();
                System.out.println("Please enter email");
                customer.setEmail(in.nextLine());
                System.out.println("Please enter Name");
                customer.setName(in.nextLine());
                System.out.println("Please enter password");
                customer.setPassword(in.nextLine());
                loginService.signUp(customer);
            }
            else if(selection == 2) {
                Customer customer = new Customer();
                System.out.println("Please enter email");
                customer.setEmail(in.nextLine());
                System.out.println("Please enter Password");
                customer.setPassword(in.nextLine());
                Customer cus = loginService.login(customer.getEmail(), customer.getPassword());
                if(cus != null) {
                    loggedInuser = cus;
                    System.out.println("Login successful, Name : " + cus.getName());
                }
                else {
                    loggedInuser = null;
                }
            }
            else if(selection == 3) {
                Customer customer1 = new Customer();
                customer1.setEmail("praveen@gmail.com");
                customer1.setName("Praveen");
                customer1.setPassword("121");

                Customer customer2 = new Customer();
                customer2.setEmail("naveen@gmail.com");
                customer2.setName("Naveen");
                customer2.setPassword("121");

                Customer customer3 = new Customer();
                customer3.setEmail("sonu@gmail.com");
                customer3.setName("Sonu");
                customer3.setPassword("1212121");

                Customer customer4 = new Customer();
                customer4.setEmail("monu@gmail.com");
                customer4.setName("Monu");
                customer4.setPassword("23232");

                loginService.signUp(customer1);
                loginService.signUp(customer2);
                loginService.signUp(customer3);
                loginService.signUp(customer4);

            }
            else if(selection == 4) {
                if(loggedInuser == null) {
                    System.out.println("Please login in to use this feature");
                    continue;
                }
                
                System.out.println("Enter comma seprated group members to add");
                String userNames = in.nextLine();
                System.out.println("Enter Group Name");
                String groupName = in.nextLine();
                
                if(groupService.createGroup(loggedInuser, userNames.split(","), groupName)) {
                    System.out.println("Group created succesfully");
                }
                
            }
            else if(selection == 5) {
                if(loggedInuser == null) {
                    System.out.println("Please login in to use this feature");
                    continue;
                }
                System.out.println("Here are the groups you are part of ");
                System.out.println(groupService.getMyGroups(loggedInuser.getEmail()));
            }
            else if(selection == 6) {
                System.out.println("Enter amount");
                double amount = Double.parseDouble(in.nextLine());
                System.out.println("Enter groupId");
                String groupId = in.nextLine();
                Group gr = groupService.addLog(loggedInuser, amount, groupId);
                System.out.println("Here is the updated group ");
                System.out.println(gr.getCustomerAmountStatus());
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