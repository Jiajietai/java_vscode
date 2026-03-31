import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BikeService {

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

        System.out.println("Please enter your current location:");
        location = input.nextLine();
        validateLocation(location);

        input.close();

        if(!locationValid){
            return;
        }

        System.out.println("Simulating e-bike reservation…");

        reserveBike(bikeID);

    }

    private void validateLocation(String location){
        for(Bike bike : BikeDatabase.bikes){
            if(bike.getLocation().equals(location) && bike.isAvailable()){
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
            }
        }
        System.out.println(" Sorry, no bikes are available at the location you requested. Please try again later.");
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


}
