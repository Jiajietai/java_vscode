
public class RegularUser  extends RegisteredUsers{
    public RegularUser(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardProvider, String cardExpiryDate, int cvv, String userType, String[] lastThreeTrips) {
        super( fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType, lastThreeTrips);
    }


    @Override
    public double calculateFare(double BASE_FARE) {
        return BASE_FARE;
    }

    @Override
    public void displayUserType(){
        System.out.println("Regular User");
    }

}
