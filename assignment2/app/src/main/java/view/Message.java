package view;

/**
 * Messages class with opeartions that returns notices.
 */
public class Message {

  public void reEnterContractDateMessage() {
    System.out.println(
        "\nThe item is not available for the period you specify. Please try to enter new start date and end date.");
  }

  public void notEnoughCreditsMessage() {
    System.out.println("\nThe lender doesnt have enough credits!!!!");
  }

  public void changeItemInfoMessage() {
    System.out.println("\nThe item infomation has been successfully changed");
  }

  public void changeMemberInfoMessage() {
    System.out.println("\nThe member information has been successfully changed");
  }

  public void addNewContractInfoMessage() {
    System.out.println("\nThe New Contract has been successfully added!");
  }

  public void deleteExistingItemMessage() {
    System.out.println("\nThe item has been successfully deleted.");
  }

  public void deleteMemberMessage() {
    System.out.println("\nThe member has been successfully deleted.");
  }

  public void createNewItemMessage() {
    System.out.println("\nA new item has been successfully created.");
  }

  public void addMemberMesssge() {
    System.out.println("\nThe member has been successfully added.");
  }

  public void pleaseTryAgainMessage() {
    System.out.println("Please try again...make sure that you type unique email and phone number.");
  }

  public void stopSystemMessage() {
    System.out.println("\nThe execuation of the lending system stopped now.");
  }

  public void shortMemberInfoMessage() {
    System.out.println("\nA short version of all members' information can be seen as follows:");
  }

  public void showMemberIdMessage(String id) {
    System.out.println("\nThe member id is " + id + "\nYou may need ID to do information check.");

  }

  public void noInputWarnings() {
    System.out.println("No input has been typed so go back to main menu");
    System.out.println("=================================================");
  }

}
