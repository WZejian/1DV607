package model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class of gathering all members.
 */
public class MemoryRegistry implements RegistryInterface {
  private List<Member> allMembers;
  private Random random = new Random();

  /**
   * Creates Registry object.
   */
  public MemoryRegistry() {
    loadFile();
  }

  /**
   * Get all members from registry.
   */
  @SuppressFBWarnings
  public Iterable<Member> getMembers() {
    return allMembers;
  }

  /**
   * Return the member with a given id.
   */
  public Member getMemberById(String id) {
    for (Member member : allMembers) {
      if (id.equals(member.getId())) {
        return member;
      }
    }
    return null;
  }

  /**
   * Generates unique id for a new member.
   */
  public String generateUniqueId() {
    while (true) {
      String id = "";
      int idLength = 6;
      for (int i = 0; i < idLength; i++) {
        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
        if (charOrNum.equals("char")) {
          int upperOrLower = random.nextInt(2) % 2 == 0 ? 65 : 97;
          id += (char) (upperOrLower + random.nextInt(26));
        } else if (charOrNum.equals("num")) {
          id += String.valueOf(random.nextInt(10));
        }
      }
      if (getMemberById(id) == null) {
        return id;
      } else {
        continue;
      }
    }
  }

  /**
   * Check if the email is unique.
   */
  public boolean uniqueEmail(String email) {
    for (Member member : allMembers) {
      if (email.equals(member.getEmail())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check if the phone number is unique.
   */
  public boolean uniquePhoneNo(String phoneNo) {
    for (Member member : allMembers) {
      if (phoneNo.equals(member.getPhoneNo())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Register a new member to the registry with name and email.
   */
  public Member registerMember(String name, String email, String phoneNo, int registrationDate, int credits) {
    if (!uniqueEmail(email) || !uniquePhoneNo(phoneNo)) {
      return null;
    }
    String id = generateUniqueId();
    Member member = new Member(name, email, phoneNo, id, registrationDate, credits);
    return member;
  }

  /**
   * Add a member.
   */
  public void addMember(Member member) {
    allMembers.add(member);
  }

  /**
   * Delete a member.
   */
  public void deleteMember(Member member) {
    allMembers.remove(member);
  }

  /**
   * Return a list of items which are searched by category.
   */
  public Iterable<Item> getItemListByCategory(String category) {
    Iterable<Item> itemListByCategory = new ArrayList<Item>();
    for (Member mem : allMembers) {
      Iterable<Item> ownedItems = mem.getOwnedItems();
      for (Item item : ownedItems) {
        if (item.getCategory().equals(category)) {
          ((ArrayList<Item>) itemListByCategory).add(item);
        }
      }
    }
    return itemListByCategory;
  }

  /**
   * Return an item which is searched by name.
   */
  public Item getItemByName(String itemName) {
    for (Member mem : allMembers) {
      Iterable<Item> ownedItems = mem.getOwnedItems();
      for (Item item : ownedItems) {
        if (item.getItemName().equals(itemName)) {
          return item;
        }
      }
    }

    return null;

  }

  /**
   * Remove an exiting member.
   */
  public Member unregisterMember(String id) {
    Member member = getMemberById(id);
    if (member == null) {
      return null;
    }
    allMembers.remove(member);
    return member;
  }

  /**
   * Check if an item's name is unique or not.
   */
  public boolean uniqueItemName(String itemName) {
    boolean isUnique = true;
    Iterable<Member> members = getMembers();
    for (Member mem : members) {
      Iterable<Item> items = mem.getOwnedItems();
      for (Item item : items) {
        if (item.getItemName().equals(itemName)) {
          isUnique = false;
        }
      }
    }
    return isUnique;
  }

  /**
   * Get a member list from a persistent storage.
   */
  public void loadFile() {
    allMembers = new ArrayList<>();
    Member mem1 = new Member("Aristotle", "aristotle@person.com", "046123456", "4Hj7c9", 2, 300);
    Member mem2 = new Member("Plato", "plato@person.com", "046456789", "70LoPz", 0, 100);
    Member mem3 = new Member("Socrates", "socrates@person.com", "046147258", "8qWm3i", 1, 100);
    allMembers.add(mem1);
    allMembers.add(mem2);
    allMembers.add(mem3);
    Item item1 = new Item("Sport", "Yoga mat", "middle-sized comfy yoga mat, 70% new", 0, 50, false, mem2);
    Item item2 = new Item("Tool", "bottle opener", "dragon-shaped bottle opener, very convenient", 0, 10, false, mem3);
    mem1.addItem(item1);
    mem1.addItem(item2);
    new Contract(5, 7, item2, mem3);    
  }

  public void saveFile() {
    
  }
}
