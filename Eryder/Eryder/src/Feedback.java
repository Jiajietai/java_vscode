
public class Feedback {
    
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void  analyseFeedback(boolean isConcatenation,String sent1, String sent2, String sent3, String sent4, String sent5){
        if (isConcatenation) {
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5);
        }
        checkFeedbackLength(completeFeedback);
        creatReveiwID(firstName, lastName,completeFeedback);
    }

    private String feedbackUsingConcatenation(String sent1, String sent2, String sent3, String sent4, String sent5) {
        String completeFeedback = sent1 + " " + sent2 + " " + sent3 + " " + sent4 + " " + sent5;
        return completeFeedback;
    }

    private String feedbackUsingStringBuilder(String sent1, String sent2, String sent3, String sent4, String sent5) {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ").append(sent2).append(" ").append(sent3).append(" ").append(sent4).append(" ").append(sent5);
        return sb.toString();
    }

    private boolean checkFeedbackLength(String feedback) {
        if (feedback.length() > 500) {
            longFeedback = true;
            return true;
        } else {
            longFeedback = false;
            return false;
        }
    }

    private String creatReveiwID(String firstName, String lastName, String completeFeedback) {
        String reviewID = firstName+ lastName;
        reviewID = reviewID.substring(2, 6);
        reviewID = reviewID.toUpperCase();
        reviewID = reviewID + completeFeedback;
        reviewID = reviewID.substring(10, 15);
        reviewID = reviewID + completeFeedback.length() + "_";
        reviewID = reviewID + System.currentTimeMillis();
        reviewID = reviewID.replaceAll(" ", "");
        return reviewID;
    }

    @Override
    public String toString() {
        return "Feedback{" + "\n" + "firstName='" + firstName + "\n" + ", lastName='" + lastName + "\n" + ", email='" + email + "\n" + ", completeFeedback='" + completeFeedback + "\n" + ", reviewID='" + reviewID + "\n" + ", whether a longFeedback" + longFeedback +  "\n" +'}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
}
