import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class RentalService {
    private String bikeID;

    UserRegistration user = new UserRegistration();
    ActiveRental activeRental;
    List<ActiveRental> activeRentalsList = new LinkedList<>();

    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");

        System.out.println("Displaying the active rentals…");

        viewActiveRentals();

        System.out.println("Simulating the end of the trip…");

        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end…");

        viewActiveRentals();
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
