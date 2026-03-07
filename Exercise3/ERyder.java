package Exercise3;

public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private float kmDriven;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, float kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }
    
    public ERyder(){}

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
    public float getKmDriven() {
        return kmDriven;
    }
}
