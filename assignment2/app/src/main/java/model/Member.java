package model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Member class.
 */
public class Member {
  private String id;
  private String name;
  private String email;
  private String phoneNo;
  private int registrationDate;

  private int credits;

  private List<Item> ownedItems = new ArrayList<>();
  private List<Item> lentItems = new ArrayList<>();

  /**
   * Creates a member object.
   */
  public Member(String name, String email, String phoneNo, String id) {
    this.name = name;
    this.email = email;
    this.phoneNo = phoneNo;
    this.id = id;
  }

  /**
   * Creates a member object.
   */
  public Member(String name, String email, String phoneNo, String id, int registrationDate, int credits) {
    this.name = name;
    this.email = email;
    this.phoneNo = phoneNo;
    this.id = id;
    this.registrationDate = registrationDate;
    this.credits = credits;
  }

  /**
   * Creates a member object.
   */
  public Member(String name, String email, String phoneNo, int registrationDate, int credits) {
    this.name = name;
    this.email = email;
    this.phoneNo = phoneNo;
    this.registrationDate = registrationDate;
    this.credits = credits;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setRegistrationDate(int registrationDate) {
    this.registrationDate = registrationDate;
  }

  public int getRegistrationDate() {
    return registrationDate;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public int getCredits() {
    return credits;
  }

  public void addCredits(Member m, int amount) {
    this.credits += m.getCredits() + amount;
  }

  /**
   * Return all the items that the members owns.
   */
  @SuppressFBWarnings
  public Iterable<Item> getOwnedItems() {
    return ownedItems;
  }

  /**
   * Return all the items that the members lent.
   */
  @SuppressFBWarnings
  public Iterable<Item> getLentItems() {
    return lentItems;
  }

  /**
   * return the item by matching the name.
   */
  public Item getItemByName(String name) {
    for (Item item : ownedItems) {
      if (name.equals(item.getItemName())) {
        return item;
      }
    }
    return null;
  }

  /**
   * Add an item to a member.
   */
  public void addItem(Item item) {
    ownedItems.add(item);
    credits += 100;
    item.setOwner(this);
  }

  /**
   * Delete an item to a member.
   */
  public void deleteItem(Item item) {
    ownedItems.remove(item);
    credits -= 100;
  }

  /**
   * Add lent item.
   */
  public void addLentItem(Item item) {
    lentItems.add(item);
    creditsDeduced(item.getContractByLender(this));
  }

  /**
   * Credits deduced according to contract.
   */
  public boolean creditsDeduced(Contract contract) {
    int noOfDays = contract.getEndDate() - contract.getStartDate() + 1;
    int totalCost = contract.getItem().getCost() * noOfDays;
    if (credits >= totalCost) {
      credits -= totalCost;
      return true;
    }
    return false;
  }

  /**
   * checks if a member has enough credits to lend an item.
   */
  public boolean checkEnoughCredit(Member member, Item item, int start, int end) {

    int numOfDays = end - start + 1;
    int totalCost = item.getCost() * numOfDays;
    if (member.getCredits() >= totalCost) {
      return true; // member has enough credits to lend an item
    } else {
      return false;
    }
  }

}
