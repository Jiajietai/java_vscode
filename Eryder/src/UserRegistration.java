import java.time.LocalDate;
import java.util.Scanner;

public class UserRegistration {

    private static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    private static final double VIP_DISCOUNT_UNDER_18 = 20.0;
    private static final double VIP_BASE_FEE = 100.0;

    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean emailValid;
    private boolean minorAndBirthday;
    private boolean minor;
    private boolean ageValid;
    private boolean cardNumberValid;
    private boolean cardStillValid;
    private boolean validCVV;

    public void registration(){
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the ERyder Registration.\nHere are your two options:\n1. Register as a Regular User\n2. Register as a VIP User\nPlease enter your choice (1 or 2):");
        int numOfUserType = input.nextInt();
        input.nextLine();
        if(numOfUserType == 1){
            userType = "Regular User";
        }
        else if(numOfUserType == 2){
            userType = "VIP User";
        }
        else{
            System.out.println("Invalid choice. Please restart the registration process.");
            input.close();
            return;
        }

        System.out.println("Please give us your fullname.");
        fullName = input.nextLine();

        System.out.println("Please give us your emailaddress.");
        emailAddress = input.nextLine();
        System.out.println("Check your email address's validity...");
        emailValid = analyseEmail(emailAddress);

        System.out.println("Please give us your birthday as YYYY-MM-DD.");
        dateOfBirth = input.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        ageValid = analyseAge(dob);

        System.out.println("Please give us your cardnumber(only Visa, MasterCard, and American Express cards are accepted):");
        cardNumber = input.nextLong();
        input.nextLine();
        cardNumberValid = analyseCardNumber(cardNumber);

        System.out.println("Please give us your card's expiry date as YYYY-MM-DD:");
        cardExpiryDate = input.nextLine();
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);

        System.out.println("Please give us your card's CVV:");
        cvv = input.nextInt();
        validCVV = analyseCVV(cvv);

        finalCheckpoint();

        input.close();
    }

    private boolean analyseEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            System.out.println("Email address is valid.");
        } else {
            System.out.println("Invalid email address. Please restart the registration process.");
            registration();
        }

        return true;
    }

    private boolean analyseAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dob.getYear();
        if (today.getDayOfYear() < dob.getDayOfYear()) {
            age--;
        }
        boolean isBirthday;
        if(today.getDayOfYear() == dob.getDayOfYear()){
            isBirthday = true;
        }
        else{
            isBirthday = false;
        }

        if(userType.equals("VIP User")){
            if (age <= 18 && isBirthday && age > 12) {
                System.out.println("Happy Birthday!\nYou get 25% discount on the VIP subscription fee for being born today and being under 18!");
                minorAndBirthday = true;
            } else if (age < 18 && age > 12) {
                System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                minor = true;
            } else if (age <= 12 || age > 120) {
                System.out.println("Looks like you are either too young or already dead. Sorry, you can’t be our user. Have a nice day.");
                System.exit(0);
            }
        }

        return true;
    }

    private boolean analyseCardNumber(long cardNumber) {
        String cardNuminStr = Long.toString(cardNumber);
        int firstTwoDigits = Integer.parseInt(cardNuminStr.substring(0, 2));
        int firstFourDigits = Integer.parseInt(cardNuminStr.substring(0, 4));
        
        if(cardNuminStr.startsWith("4") && (cardNuminStr.length() == 13 || cardNuminStr.length() == 15)){
            cardProvider = "Visa";
        }else if(cardNuminStr.length() == 16 && ((firstTwoDigits >= 51 && firstTwoDigits <= 55) || (firstFourDigits >= 2221 && firstFourDigits <= 2720))){
            cardProvider = "MasterCard";
        }else if((cardNuminStr.startsWith("34") || cardNuminStr.startsWith("37")) && cardNuminStr.length() == 15){
            cardProvider = "American Express";
        }else{
            System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card.\nGoing back to the start of the registration.");
            registration();
        }

        return true;
    }

    private boolean analyseCardExpiryDate(String cardExpiryDate) {
        int year = 2000 + Integer.parseInt(cardExpiryDate.substring(0,2 ));
        int month = Integer.parseInt(cardExpiryDate.substring(3, 5));
        
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        if(year >= currentYear || (year == currentYear && month >= currentMonth)){
            System.out.println("The card is still valid");
        }else{
            System.out.println("Sorry, your card has expired. Please use a different card.\nGoing back to the start fo the registration process...");
            registration();
        }

        return true;
    }

    private boolean analyseCVV(int cvv){
        String cvvInStr = Integer.toString(cvv);
        if((cardProvider.equals("Visa") && cvvInStr.length() == 3 ) || ( cardProvider.equals("MasterCard") && cvvInStr.length() == 3 ) || (cardProvider.equals("American Express") && cvvInStr.length() == 4)){
            System.out.println("CVV is valid.");
        }else{
            System.out.println("Invalid CVV for the given card.\nGoing back to the start of the registration process.");
            registration();
        }

        return true;
    }

    private void finalCheckpoint(){
        if(emailValid && ageValid && cardNumberValid && cardStillValid && validCVV){
            chargeFees();
        }else{
            if(!emailValid){
                System.out.println("Invalid email address");
            }
            if(!ageValid){
                System.out.println("Invalid age");
            }
            if(!cardNumberValid){
                System.out.println("Invalid card number");
            }
            if(!cardStillValid){
                System.out.println("Card has expired");
            }
            if(!validCVV){
                System.out.println("Invalid CVV");
            }

            System.out.println("Going back to the start of the registration process.");
            
            registration();
        }
    }

    private void chargeFees(){
        if(minorAndBirthday){
            feeToCharge = VIP_BASE_FEE * (1 - VIP_DISCOUNT_UNDER_18_BIRTHDAY / 100);
        }else if(minor){
                feeToCharge = VIP_BASE_FEE * (1 - VIP_DISCOUNT_UNDER_18 / 100);
        }else{
            feeToCharge = VIP_BASE_FEE;
        }

        System.out.println("Thank you for your payment.\nA fee of " + feeToCharge + " has been charged to your card ending with " + (Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4)));
        }

        @Override
        public String toString(){
            String cardNumberStr = Long.toString(cardNumber);
            String censoredPart = cardNumberStr.substring(0, cardNumberStr.length() - 4).replaceAll(".", "*");
            String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
            String censoredCardNumber = censoredPart + lastFourDigits;
            return "Registration successful! Here are your details:" +
                    "\nUser Type:'" + userType +
                    "\nFull Name: " + fullName +
                    "\nEmail Address:" + emailAddress +
                    "\nDate of Birth:" + dateOfBirth +
                    "\nCard Number: " + censoredCardNumber +
                    "\nCard Provider: " + cardProvider +
                    "\nCard Expiry Date: " + cardExpiryDate;
        }
        
}