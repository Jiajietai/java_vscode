import java.time.LocalDateTime;
import java.util.*;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;


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

        System.out.println("Please enter your current location:");
        location = input.nextLine();

        input.close();

        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if(!locationValid){
            return;
        }

        System.out.println("Simulating e-bike reservation…");

        reserveBike(bikeID);

        System.out.println("Displaying the active rentals…");

        viewActiveRentals();

        System.out.println("Simulating the end of the trip…");

        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end…");

        viewActiveRentals();
    }

    private String analyseRequest(boolean isRegisteredUser, String emailAddress, String location){
        UserRegistration userReg = new UserRegistration();

        if(isRegisteredUser){
            System.out.println("Welcome back, " + emailAddress + "!");
        }else {
            System.out.println(" You’re not our registered user. Please consider registering.");
            userReg.registration();
        }
        return validateLocation(location);
    }

    private String validateLocation(String location){
        for(Bike bike : BikeDatabase.bikes){
            if(bike.getLocation().equals(location) && bike.isAvailable()){
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println(" Sorry, no bikes are available at the location you requested. Please try again later.");
        return null;
    }

    private void reserveBike(String bikeID){
        if(bikeID != null){
            for(Bike bike : BikeDatabase.bikes){
                if(bike.getBikeID().equals(bikeID)){
                    tripStartTime = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println(" Reserving the bike with the " + bikeID + ". Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                    ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        }else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
        }
    }

    private void viewActiveRentals(){
        if(activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        }else {
            for(ActiveRental activeRental : activeRentalsList){
                System.out.println(activeRental);
            }
        }
    }

    private void removeTrip(String bikeID){
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental currentTrip = iterator.next();
            if (currentTrip.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        for(Bike bike : BikeDatabase.bikes){
            if(bike.getBikeID().equals(bikeID)){
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
                }
        }
        
    }




}

