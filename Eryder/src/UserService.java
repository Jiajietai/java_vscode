import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private boolean isRegisteredUser;
    private String emailAddress;


    UserRegistration user = new UserRegistration();
    ActiveRental activeRental;
    List<ActiveRental> activeRentalsList = new LinkedList<>();

    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter 'true' if you are a registered user, or 'false' if you are not:");
        String ifRegisteredUser = input.nextLine();
        if (ifRegisteredUser.equalsIgnoreCase("true")) {
            isRegisteredUser = true;
        } else if (ifRegisteredUser.equalsIgnoreCase("false")) {
            isRegisteredUser = false;
        } else {
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
            input.close();
            return;
        }

        System.out.println("Please enter your email address to register:");
        emailAddress = input.nextLine();

        input.close();

        analyseRequest(isRegisteredUser, emailAddress);
    }

    private void analyseRequest(boolean isRegisteredUser, String emailAddress){
        UserRegistration userReg = new UserRegistration();

        if(isRegisteredUser){
            System.out.println("Welcome back, " + emailAddress + "!");
        }else {
            System.out.println(" You're not our registered user. Please consider registering.");
            userReg.registration();
        }
    }
}
