import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Iterator;

public class BikeService {
    private String emailAddress;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private Stack<ERyderLog> logStack = new Stack<>();
    private Queue<BikeRequest> logQue = new ArrayDeque<>();

    UserRegistration user = new UserRegistration();
    ActiveRental activeRental;
    List<ActiveRental> activeRentalsList = new LinkedList<>();

    public Stack<ERyderLog> getlogStack() {
        return logStack;
    }

    public Queue<BikeRequest> getlogQue() {
        return logQue;
    }

    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");

        System.out.println("Simulating e-bike reservation…");

        reserveBike(bikeID);

        System.out.println("Simulating the end of the trip…");

        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end…");

        viewActiveRentals();

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
            RentalService rentalService = new RentalService();
            String event = rentalService.getLocation();
            ERyderLog log = new ERyderLog(bikeID, "are reserved at " + event + " on " ,LocalDateTime.now());
            logStack.push(log);
        }else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
            UserService userService = new UserService();
            String userEmail = userService.getEmailaddress();
            RentalService rentalService = new RentalService();
            String location = rentalService.getLocation();
            BikeRequest que = new BikeRequest("The user " + userEmail, " didn't rent a bike successfully at "+ location + " on ", LocalDateTime.now());
            logQue.offer(que);
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
        RentalService rentalService = new RentalService();
        String event = rentalService.getLocation();
        ERyderLog  log = new ERyderLog(bikeID,"'s tirp is end at " + event + " on ",LocalDateTime.now());
        logStack.push(log);
        
        if (!logQue.isEmpty()){
            logQue.poll();
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

    public void viewSystemLogs(){
        for (ERyderLog log : logStack) {
            System.out.println(log);
        }
    }

}
