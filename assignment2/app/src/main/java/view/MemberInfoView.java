package view;

import com.google.common.collect.Lists;
import model.Contract;
import model.Item;
import model.Member;

/**
 * A view for member-related info.
 */
public class MemberInfoView {

  /**
   * Make a member's full information to a string.
   */
  public String memberFullInfo(Member member) {

    ItemInfoView iv = new ItemInfoView();

    String memberFullInfo = "\nThe member's full information:";
    memberFullInfo += "\nName: " + member.getName();
    memberFullInfo += "\nId: " + member.getId();
    memberFullInfo += "\nEmail: " + member.getEmail();
    memberFullInfo += "\nPhone Number: " + member.getPhoneNo();
    memberFullInfo += "\nRegistration Date: Day " + member.getRegistrationDate();
    memberFullInfo += "\nCurrent Credits: " + member.getCredits();
    memberFullInfo += "\nThe member owns the following items:";
    memberFullInfo += "\n==========================================";

    Iterable<Item> ownedItems = member.getOwnedItems();
    for (Item item : ownedItems) {
      memberFullInfo += iv.itemFullInfo(item);
    }
    if (Lists.newArrayList(ownedItems).size() == 0) {
      memberFullInfo += "\nThe member has not uploaded any item yet.";
    }

    memberFullInfo += "\n------------------------------------------";
    System.out.println("\nItems lent:");
    Iterable<Item> lentItems = member.getLentItems();
    for (Item item : lentItems) {
      memberFullInfo += iv.itemFullInfo(item);
    }
    if (Lists.newArrayList(lentItems).size() == 0) {
      memberFullInfo += "\nThe member has not lent any item yet.";
    }

    return memberFullInfo;
  }

  

  /**
   * Make a member's information to a string in a simple way.
   */
  public String memberInfoSimpleWay(Member member) {

    String s = "\n---------------------------------------------";
    s += "\nName: " + member.getName();
    s += "\nId: " + member.getId();
    s += "\nEmail: " + member.getEmail();
    s += "\nCurrent Credits: " + member.getCredits();

    Iterable<Item> ownedItems = member.getOwnedItems();
    int counter = Lists.newArrayList(ownedItems).size();
    s += "\nNumber of owned items: " + counter;

    return s;
  }

  

  /**
   * Make a member's information to a string in a Verbose way.
   */
  public String memberInfoVerboseWay(Member member, int time) {

    ItemInfoView iiv = new ItemInfoView();

    String s = "---------------------------------------------";
    s += "\nName: " + member.getName();
    s += "\nMember ID: " + member.getId();
    s += "\nEmail: " + member.getEmail();
    s += "\n*********************************************";

    Iterable<Item> ownedItems = member.getOwnedItems();
    for (Item item : ownedItems) {
      Iterable<Contract> contractList = item.getContracts();
      if (contractList == null) {
        s += "\n" + iiv.itemBasicInfo(item) + "Current location: at the owner's place\n";
      }
      Contract currentContract = item.getContractByDate(time);
      if (currentContract != null) {
        s += iiv.itemBasicInfo(item);
        s += "Currently lent to:  " + currentContract.getLender().getName() + " ("
            + currentContract.getLender().getId() + ")";
        s += "\nLending time period: from Day " + currentContract.getStartDate() + " to Day "
            + currentContract.getEndDate();
      } else {
        s += "\n" + iiv.itemBasicInfo(item) + "Current location: at the owner's place\n";
      }
    }
    return s;
  }
  
}
