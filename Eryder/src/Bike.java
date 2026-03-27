import java.time.LocalDateTime;

public class Bike {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private LocalDateTime lastUsedTime;
    private String location;

    public Bike(String bikeID,boolean isAvailable, int batteryLevel, LocalDateTime lastUsedTime, String location) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.lastUsedTime = lastUsedTime;
        this.location = location;
    }

    public String getBikeID() {
        return bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bike: " + '\'' +
                "bikeID='" + bikeID + '\'' +
                ", batteryLevel=" + batteryLevel + '\'' +
                ", isAvailable=" + isAvailable + '\'' +
                ", lastUsedTime=" + lastUsedTime + '\'' +
                ", location='" + location;
    }


}
