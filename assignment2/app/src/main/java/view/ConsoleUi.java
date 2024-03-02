package view;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Scanner;

/**
 * Represents a console-driven user interface.
 */
public class ConsoleUi {

  private Scanner input;

  /**
   * Creates a consoleUi object.
   */
  @SuppressFBWarnings
  public ConsoleUi(Scanner input) {
    this.input = input;
  }

  /**
   * Represents the main menu actions.
   */
  public enum Event {
    AddMember,
    DeleteMember,
    ChangeMemberInfo,
    PresentMemberFullInfo,
    ListAllMembersInfoSimpleWay,
    ListAllMembersInfoVerboseWay,
    AddItem,
    DeleteItem,
    ChangeItemInfo,
    ViewItemInfoWithContracts,
    GoToNextDay,
    CreateContract,
    InvalidInput,
    Quit
  }

  /**
   * Represents the member info that needs to be changed.
   */
  public enum MemberInfoChangeOption {
    Name,
    PhoneNumber,
    Email,
    GoBackToMainMenu
  }

  /**
   * Represents an item's info that needs to be changed.
   */
  public enum ItemInfoChangeOption {
    Name,
    Category,
    Descirption,
    Cost,
    GoBackToMainMenu
  }

  /**
   * Ask for an option to change the corresponding info of an item.
   */
  public ItemInfoChangeOption promptForItemChangingOption() {

    final String changeName = "1";
    final String changeCategory = "2";
    final String changeDescription = "3";
    final String changeCost = "4";

    while (true) {
      System.out.println(
          "Please make sure you enter a valid option:\n" + changeName + " -> Change name\n" + changeCategory
              + "-> Change category\n"
              + changeDescription + " -> Change description\n"
              + changeCost + "-> Change cost\n\nPress enter to go back to main menu.");
      String choice = input.nextLine();

      if (choice.equals(changeName)) {
        return ItemInfoChangeOption.Name;
      } else if (choice.equals(changeCategory)) {
        return ItemInfoChangeOption.Category;
      } else if (choice.equals(changeDescription)) {
        return ItemInfoChangeOption.Descirption;
      } else if (choice.equals(changeCost)) {
        return ItemInfoChangeOption.Cost;
      } else if (choice.equals("")) {
        return ItemInfoChangeOption.GoBackToMainMenu;
      }
    }
  }

  /**
   * Ask for an option to change the corresponding info of a member.
   */
  public MemberInfoChangeOption promptForMemberChangingOption() {

    final String changeName = "1";
    final String changeEmail = "2";
    final String changePhoneNo = "3";

    while (true) {
      System.out.println(
          "Please make sure you enter a valid option:\n " + changeName + " -> Change name\n " + changeEmail
              + " -> Change email\n " + changePhoneNo + " -> Change phoneNo");
      System.out.println("\n\nPress enter to go back to main menu.");
      String choice = input.nextLine();

      if (choice.equals(changeName)) {
        return MemberInfoChangeOption.Name;
      } else if (choice.equals(changeEmail)) {
        return MemberInfoChangeOption.Email;
      } else if (choice.equals(changePhoneNo)) {
        return MemberInfoChangeOption.PhoneNumber;
      } else if (choice.equals("")) {
        return MemberInfoChangeOption.GoBackToMainMenu;
      }
    }
  }

  /**
   * Ask for a new member's name.
   */
  public String promptForNewMemberName() {
    System.out.println("Enter new member's name: ");
    String memberName = input.nextLine();

    return memberName;
  }

  /**
   * Ask for a new member's email.
   */
  public String promptForNewMemberEmail() {
    System.out.println("\nPlease enter a unique email for the member: ");
    String memberEmail = input.nextLine();

    return memberEmail;
  }

  /**
   * Ask for a new member's phone number.
   */
  public String promptForNewMemberPhoneNum() {
    System.out.println("\nPlease enter a unique phone number for the member: ");
    String memberPhoneNum = input.nextLine();

    return memberPhoneNum;
  }

  /**
   * Ask for a member's id to delete this member.
   */
  public String promptForDeleteMember() {
    System.out.println("\nPlease enter the member's id to delete the member:");
    String id = input.nextLine();

    return id;
  }

  /**
   * Ask for an item's name to delete this item.
   */
  public String promptForDeleteItem() {
    System.out.println("\nPlease enter the item name to delete it:");
    String itemName = input.nextLine();

    return itemName;
  }

  /**
   * Ask for a member's id to check this member full info.
   */
  public String promptForPresentMemberFullInfo() {
    System.out.println("Please enter the member's id to show the member's full information:");
    String id = input.nextLine();

    return id;
  }

  /**
   * Ask for a new item's name.
   */
  public String promptForNewItemName() {
    System.out.println("Enter a unique name for the new item: ");
    String itemName = input.nextLine();

    return itemName;
  }

  /**
   * Ask for a member's id so an new item can be added to the member.
   */
  public String promptForMemberId() {
    System.out.println("Please enter the member's id to add the item to the member: ");
    String id = input.nextLine();

    return id;
  }

  /**
   * Ask for a new item's category.
   */
  public String promptForNewItemCategory() {
    final String tool = "Tool";
    final String vehicle = "Vehicle";
    final String game = "Game";
    final String toy = "Toy";
    final String sport = "Sport";
    final String others = "Others";

    System.out.println("Please enter a valid option to choose new item's category:"
        + " 1. " + tool
        + " 2. " + vehicle
        + " 3. " + game
        + " 4. " + toy
        + " 5. " + sport
        + " 6. " + others);

    String itemCategory;
    while (true) {
      String categoryInput = input.nextLine();
      if (categoryInput.equals("1")) {
        itemCategory = tool;
        break;
      } else if (categoryInput.equals("2")) {
        itemCategory = vehicle;
        break;
      } else if (categoryInput.equals("3")) {
        itemCategory = game;
        break;
      } else if (categoryInput.equals("4")) {
        itemCategory = toy;
        break;
      } else if (categoryInput.equals("5")) {
        itemCategory = sport;
        break;
      } else if (categoryInput.equals("6")) {
        itemCategory = others;
        break;
      } else {
        System.out.println("Incorrect input, please enter again:");
        continue;
      }
    }
    return itemCategory;
  }

  /**
   * Ask for a new item's description.
   */
  public String promptForItemDescription() {
    System.out.println("Enter a short descirption of this item: ");
    String description = input.nextLine();

    return description;
  }

  /**
   * Ask for a new item's daily cost.
   */
  public int promptForNewItemCost() {
    int cost = 0;
    String costInput = "";
    while (true) {
      try {
        System.out.println("\nPlease set an integer for the cost of the item per day: ");
        costInput = input.next();
        cost = Integer.parseInt(costInput);
        break;
      } catch (NumberFormatException e) {
        System.out.print("Invalid input, please enter again.");
      }
    }
    return cost;
  }

  /**
   * Ask for an item's name to view the item's info with contracts.
   */
  public String promptForViewItemInfoWithContracts() {
    System.out.println("\nPlease enter the item name to read its full information:");
    String itemName = input.nextLine();

    return itemName;
  }

  /**
   * Ask for a lender's id.
   */
  public String promptForLenderId() {
    System.out.println("Please enter the member's id who wants to lend an item: ");
    String id = input.nextLine();

    return id;
  }

  /**
   * Ask for an item's name which a lender wants to lend.
   */
  public String promptForItemNameForLending() {
    System.out.println("Please enter the item name for lending:");
    String itemName = input.nextLine();

    return itemName;
  }

  /**
   * Ask for a start date for a new contract.
   */
  public int promptForStartDate() {
    int startDate = 0;
    String dateInput = "";
    while (true) {
      try {
        System.out.println("Please set the start date(integer): ");
        dateInput = input.next();
        startDate = Integer.parseInt(dateInput);
        break;
      } catch (NumberFormatException e) {
        System.out.print("Invalid input, ");
      }
    }

    return startDate;
  }

  /**
   * Ask for an end date for a new contract.
   */
  public int promptForEndDate() {
    int endDate = 0;
    String dateInput = "";
    while (true) {
      try {
        System.out.println("Please set the end date for the contract");
        dateInput = input.next();
        endDate = Integer.parseInt(dateInput);
        break;
      } catch (NumberFormatException e) {
        System.out.print("Invalid input, ");
      }
    }

    return endDate;
  }

  /**
   * Ask for a member id to change the member info.
   */
  public String promptForMemberIdForChanging() {

    System.out.println("Please enter the member id  to change his/her information: ");
    String id = input.nextLine();

    return id;
  }

  /**
   * Ask for a new name for an existing member.
   */
  public String promptForNewNameForMember() {
    System.out.println("Enter a new name for the member:");
    String newName = input.nextLine();

    return newName;
  }

  /**
   * Ask for an item's name which info will be changed.
   */
  public String promptForItemNameForChanging() {
    System.out.println("Please enter item name:");
    String itemName = input.nextLine();

    return itemName;
  }

  /**
   * Wait for enter.
   */
  public void waitForEnter() {
    System.out.println("\nEnter any key or press Enter to go back to main menu:");
    input.nextLine();
  }

  /**
   * Shows the main menu.
   */
  public Event showMainMenu(int currentDate) {
    System.out.println("Welcome to the stuff lending system !");
    System.out.println("Today is Day " + currentDate);
    System.out.println("========================Main Menu=====================");
    System.out.println(" 1--Add a new member");
    System.out.println(" 2--Delete an existing member");
    System.out.println(" 3--Change the information of an existing member");
    System.out.println(" 4--Present a specific member's full information");
    System.out.println(" 5--List all members' information in a simple way.");
    System.out.println(" 6--List all members' information in a verbose way");
    System.out.println(" 7--Add a new item");
    System.out.println(" 8--Delete an existing item");
    System.out.println(" 9--Change an item's information");
    System.out.println(" 10--Present a specific item's information with contracts");
    System.out.println(" 11--Create a new contract");
    System.out.println(" g--go to next day");
    System.out.println(" q--quit");
    System.out.println("\nPlease enter the option by typing the corresponding number or character: ");
    String choice = input.nextLine();

    if (choice.equals("1")) {
      return Event.AddMember;
    } else if (choice.equals("2")) {
      return Event.DeleteMember;
    } else if (choice.equals("3")) {
      return Event.ChangeMemberInfo;
    } else if (choice.equals("4")) {
      return Event.PresentMemberFullInfo;
    } else if (choice.equals("5")) {
      return Event.ListAllMembersInfoSimpleWay;
    } else if (choice.equals("6")) {
      return Event.ListAllMembersInfoVerboseWay;
    } else if (choice.equals("7")) {
      return Event.AddItem;
    } else if (choice.equals("8")) {
      return Event.DeleteItem;
    } else if (choice.equals("9")) {
      return Event.ChangeItemInfo;
    } else if (choice.equals("10")) {
      return Event.ViewItemInfoWithContracts;
    } else if (choice.equals("11")) {
      return Event.CreateContract;
    } else if (choice.equals("g")) {
      return Event.GoToNextDay;
    } else if (choice.equals("q")) {
      return Event.Quit;
    } else {
      System.out.println("Incorrect input.");
      return Event.InvalidInput;
    }
  }
}
