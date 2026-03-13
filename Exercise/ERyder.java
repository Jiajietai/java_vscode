package Exercise;

public class ERyder {

    //private static final String COMPANY_NAME = "ERyder";
    private static final double BASE_FARE = 1.0;
    private static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final long LINKED_PHONE_NUMBER;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalUsageInMinutes;
    private double totalFare;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        LINKED_ACCOUNT = "JIAJIETAI";
        LINKED_PHONE_NUMBER = 1234567890;
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven, String linkedAccount, long linkedPhoneNumber) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        LINKED_ACCOUNT = linkedAccount;
        LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
        if (batteryLevel < 0 || batteryLevel > 100) {
            System.out.println("the batteryLevel is not valid");
        }
    }
    public String getBikeID() {
        return bikeID;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setKmDriven(float kmDriven) {
        this.kmDriven = kmDriven;
    }
    public double getKmDriven() {
        return kmDriven;
    }


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


    public void printRideDetails(int usageInMinutes) {
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Usage Time: " + usageInMinutes + " minutes");
        System.out.println("Total Fare: " + totalFare);
    }

    private double calculateFare(int usageInMinutes) {
        totalFare = BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return totalFare;
    }

    public void getcalculateFare() {
        calculateFare(totalUsageInMinutes);
    }
}
