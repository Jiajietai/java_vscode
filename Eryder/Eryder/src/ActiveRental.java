import java.time.LocalDateTime;

public class ActiveRental {
     private String rentalID;
     private String userEmail;
     private LocalDateTime tripStartTime;

     ActiveRental(String rentalID, String userEmail, LocalDateTime tripStartTime) {
        this.rentalID = rentalID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
     }

    public String getRentalID() {
        return rentalID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setTripStartTime(LocalDateTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    @Override
    public String toString() {
        return "ActiveRental: " + '\'' +
                "rentalID='" + rentalID + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", tripStartTime=" + tripStartTime;
    }

}
