package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.Member;
import model.MemoryRegistry;
import view.ConsoleUi;
import view.ConsoleUi.ItemInfoChangeOption;
import view.ConsoleUi.MemberInfoChangeOption;
import view.ItemInfoView;
import view.MemberInfoView;
import view.Message;

/**
 * This is the lendingsystem class in the controller.
 */
public class LendingManagement {

  private ConsoleUi console;
  private MemberInfoView mi = new MemberInfoView();
  private ItemInfoView ii = new ItemInfoView();
  private MemoryRegistry registry = new MemoryRegistry();
  private int currentDay = 0;
  private Message messages;

  /**
   * Initializing constructor.
   */
  @SuppressFBWarnings
  public LendingManagement() {
    Scanner s = new Scanner(System.in);
    this.console = new ConsoleUi(s);
    this.registry = new MemoryRegistry();
    this.messages = new Message();
  }

  /**
   * Starts the application.
   */
  public void doMainMenu() {
    boolean running = true;
    boolean quit = false;
    while (running) {
      ConsoleUi.Event action = console.showMainMenu(currentDay);
      switch (action) {
        case AddMember:
          addNewMember();
          break;
        case DeleteMember:
          deleteExistingMember();
          break;
        case ChangeMemberInfo:
          changeMemberInfo();
          break;
        case PresentMemberFullInfo:
          showMemberFullInfo();
          break;
        case ListAllMembersInfoSimpleWay:
          showAllMembersInfoSimpleWay();
          break;
        case ListAllMembersInfoVerboseWay:
          showAllMembersInfoVerboseWay();
          break;
        case AddItem:
          addNewItem();
          break;
        case DeleteItem:
          deleteExistingItem();
          break;
        case ChangeItemInfo:
          changeItemInfo();
          break;
        case ViewItemInfoWithContracts:
          showItemFullInfo();
          break;
        case GoToNextDay:
          advanceTime();
          break;
        case CreateContract:
          addNewContract();
          break;
        case Quit:
          messages.stopSystemMessage();
          quit = true;
          break;
        case InvalidInput:
          continue;
        default:
          break;
      }
      if (quit) {
        running = false;
      } else {
        console.waitForEnter();
      }
    }
  }

  /**
   * According to the new member info provided by a user, to create a new member,
   * generate a unique id and add it to registry, while considering no duplicate
   * email or address.
   */
  public void addNewMember() {
    String email = "";
    do {
      email = console.promptForNewMemberEmail();
    } while (!registry.uniqueEmail(email) && !email.equals(""));
    if (email.equals("")) {
      return;
    }
    String phone = "";
    do {
      phone = console.promptForNewMemberPhoneNum();
    } while (!registry.uniquePhoneNo(phone) && !phone.equals(""));
    if (phone.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    String name = console.promptForNewMemberName();
    Member newMember = new Member(name, email, phone, currentDay, 0);
    newMember.setId(registry.generateUniqueId());
    registry.addMember(newMember);
    messages.showMemberIdMessage(newMember.getId());
  }

  /**
   * Create an item according to info provided by user and add it to the
   * corresponding user.
   */
  public void addNewItem() {
    String id = "";
    do {
      id = console.promptForMemberId();
    } while (!id.equals("") && registry.getMemberById(id) == null);
    if (id.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Member member = registry.getMemberById(id);
    String itemName = "";
    do {
      itemName = console.promptForNewItemName();
    } while (!itemName.equals("") && !registry.uniqueItemName(itemName));
    if (itemName.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    String category = console.promptForNewItemCategory();
    String description = console.promptForItemDescription();
    int cost = console.promptForNewItemCost();
    Item newItem = new Item(category, itemName, description, currentDay, cost, member);
    newItem.getOwner().addItem(newItem);
    messages.createNewItemMessage();
  }

  /**
   * Delete an existing member by entering his member id and confirm by password.
   */
  public void deleteExistingMember() {
    String id = "";
    do {
      id = console.promptForDeleteMember();
    } while (registry.getMemberById(id) == null && !id.equals(""));
    if (id.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Member member = registry.getMemberById(id);
    registry.deleteMember(member);
    messages.deleteMemberMessage();
  }

  /**
   * Delete an existing item by entering the name of item.
   */
  public void deleteExistingItem() {
    String itemName = "";
    do {
      itemName = console.promptForDeleteItem();
    } while (!itemName.equals("") && registry.getItemByName(itemName) == null);
    if (itemName.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Item item = registry.getItemByName(itemName);
    Member member = item.getOwner();
    member.deleteItem(item);
    messages.deleteExistingItemMessage();
  }

  /**
   * Show a member's full information in the stuff lending system.
   */
  public void showMemberFullInfo() {
    String id = "";
    do {
      id = console.promptForPresentMemberFullInfo();
    } while (!id.equals("") && registry.getMemberById(id) == null);
    if (id.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Member member = registry.getMemberById(id);
    System.out.println(mi.memberFullInfo(member));
  }

  /**
   * Show all members' info in a simple way.
   */
  public void showAllMembersInfoSimpleWay() {

    Iterable<Member> memberList = registry.getMembers();
    messages.shortMemberInfoMessage();
    for (Member member : memberList) {
      System.out.println(mi.memberInfoSimpleWay(member));
    }
  }

  /**
   * Show all members' info in a verbose way.
   */
  public void showAllMembersInfoVerboseWay() {

    Iterable<Member> memberList = registry.getMembers();
    for (Member member : memberList) {
      System.out.println(mi.memberInfoVerboseWay(member, currentDay));
    }
  }

  /**
   * Shows an item's full info.
   */
  public void showItemFullInfo() {
    String itemName = "";
    do {
      itemName = console.promptForViewItemInfoWithContracts();
    } while (!itemName.equals("") && registry.getItemByName(itemName) == null);
    if (itemName.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Item item = registry.getItemByName(itemName);
    System.out.println(ii.itemFullInfo(item));
  }

  /**
   * add a new contract that can be used in event.
   */
  public void addNewContract() {
    String lenderId = "";
    do {
      lenderId = console.promptForLenderId();
    } while (!lenderId.equals("") && registry.getMemberById(lenderId) == null);
    if (lenderId.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }

    String itemName = "";
    do {
      itemName = console.promptForItemNameForLending();
    } while (!itemName.equals("") && registry.getItemByName(itemName) == null);
    if (itemName.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Member lender = registry.getMemberById(lenderId);
    Item item = registry.getItemByName(itemName);
    Boolean isItemAvailable = false;
    int startDate = 0;
    int endDate = 0;
    while (endDate < startDate || isItemAvailable == false) {
      startDate = console.promptForStartDate();
      endDate = console.promptForEndDate();
      isItemAvailable = item.itemAvailablility(startDate, endDate);

      if (isItemAvailable == false) {
        messages.reEnterContractDateMessage();
      }
    }

    if (lender.checkEnoughCredit(lender, item, startDate, endDate)) {
      new Contract(startDate, endDate, item, lender);
      messages.addNewContractInfoMessage();
    } else {
      messages.notEnoughCreditsMessage();
    }
  }

  /**
   * Change member info and used in doMainMenu.
   */
  public void changeMemberInfo() {
    String id = "";
    do {
      id = console.promptForMemberIdForChanging();
    } while (!id.equals("") && registry.getMemberById(id) == null);
    if (id.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Member member = registry.getMemberById(id);

    String memberName = "";
    String newEmail = "";
    String newPhoneNum = "";
    MemberInfoChangeOption choice = console.promptForMemberChangingOption();

    switch (choice) {
      case Name:
        while (memberName.equals("")) {
          memberName = console.promptForNewNameForMember();
        }
        member.setName(memberName);
        break;
      case PhoneNumber:
        while (newPhoneNum.equals("") || !registry.uniquePhoneNo(newPhoneNum)) {
          newPhoneNum = console.promptForNewMemberPhoneNum();
        }
        member.setPhoneNo(newPhoneNum);
        break;
      case Email:
        while (newEmail.equals("") || !registry.uniqueEmail(newEmail)) {
          newEmail = console.promptForNewMemberEmail();
        }
        member.setEmail(newEmail);
        break;
      case GoBackToMainMenu:
        doMainMenu();
        break;
      default:
        break;
    }

    messages.changeMemberInfoMessage();
  }

  /**
   * Change item info and used in doMainMenu.
   */
  public void changeItemInfo() {
    String itemName = "";
    do {
      itemName = console.promptForItemNameForChanging();
    } while (!itemName.equals("") && registry.getItemByName(itemName) == null);
    if (itemName.equals("")) {
      messages.noInputWarnings();
      doMainMenu();
    }
    Item item = registry.getItemByName(itemName);
    ItemInfoChangeOption choice = console.promptForItemChangingOption();
    String newName = "";

    switch (choice) {
      case Name:
        while (!registry.uniqueItemName(newName) || newName.equals("")) {
          newName = console.promptForItemNameForChanging();
        }
        item.setItemName(newName);
        break;
      case Category:
        String newCategory = console.promptForNewItemCategory();
        item.setCategory(newCategory);
        break;
      case Descirption:
        String description = console.promptForItemDescription();
        item.setDescription(description);
        break;
      case Cost:
        int newCost = console.promptForNewItemCost();
        item.setCost(newCost);
        break;
      case GoBackToMainMenu:
        doMainMenu();
        break;
      default:
        break;
    }
    messages.changeItemInfoMessage();
  }

  /**
   * A method to advande day of the lending system.
   */
  public void advanceTime() {
    currentDay++;
  }
}
