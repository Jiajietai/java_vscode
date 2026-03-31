import java.util.*;

public class AdminPanel {

    UserService userService = new UserService();

    public void userManagementOptions() {
        System.out.println("Welcome to E-Ryder Admininstrator Panel." +
            "\n What do you want to do?" +
            "\n 1.Add New User" +
            "\n 2. View Registered Users" +
            "\n 3. Remove Registered Users" +
            "\n 4. Update Registered Users" +
            "\n 5. Demo the Bike Rental System" +
            "\n 6. EXIT");
        
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                userService.addNewUsers();
                break;
            case 2:
                userService.viewRegisteredUsers();
                break;
            case 3:
                userService.removeRegisteredUsers();
                break;
            case 4:
                userService.updateRegisteredUsers();
                break;
            case 5:
                RentalService bikeRental = new RentalService();
                bikeRental.simulateApplicationInput();
                break;
            case 6:
                System.out.println("Exiting Admin Panel.");
                break;
            default:
                System.out.println("”Invalid choice. Please try again");
                userManagementOptions();
        }

        input.close();
    }

}