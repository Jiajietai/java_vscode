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
}
