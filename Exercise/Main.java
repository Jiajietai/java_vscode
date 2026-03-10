package Exercise;

public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder( "Bike01", 90, true, 10.0f);

        bike1.ride();
        bike1.printBikeDetails();
        bike1.getcalculateFare();
        bike1.printRideDetails(35);

        ERyder bike2 = new ERyder( "Bike02", 80, true, 5.5f, "JIAJIETAI", 1234567890);
        
        bike2.ride();
        bike2.printBikeDetails();
        bike2.getcalculateFare();
        bike2.printRideDetails(30);
    }   
}