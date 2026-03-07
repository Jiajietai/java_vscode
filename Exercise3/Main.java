package Exercise3;

public class Main {
    public static void main(String[] args) {
        ERyder bike = new ERyder();

        bike.setBikeID("Bike01");
        bike.setBatteryLevel(100);
        bike.setIsAvailable(true);
        bike.setKmDriven(10.1f);

        bike.ride();
        bike.printBikeDetails();
    }   
}