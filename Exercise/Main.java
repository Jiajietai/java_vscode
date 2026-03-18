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


        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";

        Feedback feedback1 = new Feedback("John", "Doe", "john.doe@example.com");
        feedback1.analyseFeedback(true, sent1, sent2, sent3, sent4, sent5);


        UserRegistration user = new UserRegistration();
        user.registration();
        System.out.println(user);

    }  
}