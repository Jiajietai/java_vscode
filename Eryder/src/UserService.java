import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class UserService {
    private boolean isRegisteredUser;
    private String emailAddress;

    UserRegistration user = new UserRegistration();
    ActiveRental activeRental;
    List<ActiveRental> activeRentalsList = new LinkedList<>();
    List<RegisteredUsers> registeredUsers = new ArrayList<>();

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

    public void addNewUsers(){

        Scanner input = new Scanner(System.in);
        System.out.println("How many users would you like to add?");
        int i = input.nextInt();
        input.nextLine();
        
        for (int j = 0; j < i; j++) {
            System.out.println("Enter Full Name:");
            String fullName = input.nextLine();

            System.out.println("Enter Email Address:");
            String emailAddress = input.nextLine();

            System.out.println("Enter Date of Birth (YYYY-MM-DD):");
            String dateOfBirth = input.nextLine();

            System.out.println("Enter Card Number:");
            long cardNumber = input.nextLong();
            input.nextLine();

            System.out.println("Enter Card Provider:");
            String cardProvider = input.nextLine();

            System.out.println("Enter Card Expiry Date (MM/YY):");
            String cardExpiryDate = input.nextLine();

            System.out.println("Enter CVV:");
            int cvv = input.nextInt();
            input.nextLine();

            System.out.println("Enter User Type (Regular or VIP):");
            String userType = input.nextLine();

            String[] lastThreeTrips = new String[3];

            for (int k = 0; k < 3; k++) {
            System.out.println("Enter Last " + (j+1) + " Trips:");
            System.out.println("Trip date (in YYYY-MM-DD format):");
            String tripDate = input.nextLine();
            System.out.println("Trip source:");
            String tripSource = input.nextLine();
            System.out.println("Trip destination:");
            String tripDestination = input.nextLine();
            System.out.println("Trip fare:");
            double tripFare = input.nextDouble();
            input.nextLine();
            System.out.println("feedback(can be NULL):");
            String feedBack = input.nextLine();

            StringBuilder tripDetails = new StringBuilder();
            tripDetails.append("Date: ").append(tripDate).append(", ").append("Source: ").append(tripSource).append(", ").append("Destination: ").append(tripDestination).append(", ").append("Fare: ").append(tripFare).append(", ").append("Feedback: ").append(feedBack);
            lastThreeTrips[j] = tripDetails.toString();
            }

            RegisteredUsers newUser;
            if (userType.equalsIgnoreCase("VIP User")) {
                newUser = new VIPUser(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType, lastThreeTrips);} 
            else {
                newUser = new RegularUser(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType, lastThreeTrips);}
            registeredUsers.add(newUser);
        }

        input.close();
    }

    public void viewRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users to display");
        } else {
            for (RegisteredUsers user : registeredUsers) {
                System.out.println(user);
            }
        }
    }

    public void removeRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("”No registered users to remove");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the email address of the user you want to remove:");
            String emailToRemove = input.nextLine();

            boolean isFound = false;
            Iterator<RegisteredUsers> iterator = registeredUsers.iterator();
            while (iterator.hasNext()) {
                RegisteredUsers user = iterator.next();
                if (user.getEmailAddress().equals(emailToRemove)) {
                    iterator.remove();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No user found with this email address");
            }

            input.close();
        }
        
    }

    public void updateRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("”No registered users to update");
        }else{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the email address of the user you want to update:");
            String emailToUpdate = input.nextLine();

            boolean isFound = false;
            for (RegisteredUsers user : registeredUsers) {
                if (user.getEmailAddress().equals(emailToUpdate)) {
                    System.out.println("Enter new Full Name:");
                    String fullName = input.nextLine();
                    if (!fullName.isEmpty()) {
                        user.setFullName(fullName);
                    }

                    System.out.println("Enter new Date of Birth (YYYY-MM-DD):");
                    String dateOfBirth = input.nextLine();
                    if (!dateOfBirth.isEmpty()) {
                        user.setDateOfBirth(dateOfBirth);
                    }

                    System.out.println("Enter new Card Number:");
                    long cardNumber = input.nextLong();
                    input.nextLine();
                    if(cardNumber != 0) {
                        user.setCardNumber(cardNumber);
                    }

                    System.out.println("Enter new Card Provider:");
                    String cardProvider = input.nextLine();
                    if (!cardProvider.isEmpty()) {
                        user.setCardProvider(cardProvider);
                    }

                    System.out.println("Enter new Card Expiry Date (MM/YY):");
                    String cardExpiryDate = input.nextLine();
                    if (!cardExpiryDate.isEmpty()) {
                        user.setCardExpiryDate(cardExpiryDate);
                    }

                    System.out.println("Enter new CVV:");
                    int cvv = input.nextInt();
                    input.nextLine();
                    if(cvv != 0) {
                        user.setCvv(cvv);
                    }

                    System.out.println("Enter new User Type (Regular or VIP):");
                    String userType = input.nextLine();
                    if (!userType.isEmpty()) {
                        user.setUserType(userType);
                    }

                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No user found with this email address");
            }

            input.close();
        }
    
    }

    public String getEmailaddress() {
        return emailAddress;
    }
    
}
