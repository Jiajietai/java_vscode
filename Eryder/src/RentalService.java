import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RentalService {
    private boolean locationValid;
    private String location;

    ActiveRental activeRental;
    List<ActiveRental> activeRentalsList = new LinkedList<>();
    Stack<ERyderLog> logStack = new Stack<>();

    public String getLocation() {
        return location;
    }

    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");

        System.out.println("Displaying the active rentals…");

        viewActiveRentals();

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your current location:");
        location = input.nextLine();
        validateLocation(location);

        input.close();

        if(!locationValid){
            return;
        }

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

    private void viewActiveRentals(){
        if(activeRentalsList.isEmpty()){
            System.out.println("No active rentals at the moment.");
        }else {
            for(ActiveRental activeRental : activeRentalsList){
                System.out.println(activeRental);
            }
        }
    }

}
