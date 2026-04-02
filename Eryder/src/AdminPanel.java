import java.util.*;

public class AdminPanel {
    UserService userService = new UserService();
    BikeService bikeService = new BikeService( );

    public void userManagementOptions() {
        System.out.println("Welcome to E-Ryder Admininstrator Panel." +
            "\n What do you want to do?" +
            "\n 1.Add New User" +
            "\n 2. View Registered Users" +
            "\n 3. Remove Registered Users" +
            "\n 4. Update Registered Users" +
            "\n 5. Demo the Bike Rental System" +
            "\n 6. ViewSystem Logs" +
            "\n 7. ManagePending Bike Requests" +
            "\n 8. EXIT");
        
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
                bikeService.viewSystemLogs();
                break;
            case 7:
                managePendingBikeRequests();
                break;
            case 8:
                System.out.println("Thank you for using E-Ryder. Have a nice day!");
                break;
            default:
                System.out.println("”Invalid choice. Please try again");
                userManagementOptions();
        }

        input.close();
    }

    private void managePendingBikeRequests() {
        System.out.println(" What do you want to do?" +
            "\n 1.View Queue" +
            "\n 2.Update Queue" +
            "\n 3.Exit" );

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (BikeRequest que : bikeService.getlogQue()) {
                        System.out.println(que);
                    }
                    break;
                case 2:
                    bikeService.getlogQue().poll();
                    break;
                default:
                    break;
            }
            
            input.close();
    }

}