
public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private Boolean isAvailable;
    private float kmDriven;

    public ERyder(String bikeID, int batteryLevel, Boolean isAvailable, float kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
    
    public ERyder() {}

    public void ride() {
        if (batteryLevel > 0 && isAvailable) {
            System.out.println("the bike is available");
        }
        else {
            System.out.println("the bike is not available");
        }
    }

    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel);
        System.out.println("Is Available: " + isAvailable);
        System.out.println("KM Driven: " + kmDriven);
    }

    public String getBikeID() {
        return bikeID;
    }
}
