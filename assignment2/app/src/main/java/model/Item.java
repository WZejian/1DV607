package model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Item class.
 */
public class Item {

  private String category;
  private String itemName;
  private String description;
  private int creationDate;
  private int cost;
  private boolean lendStatus;
  private Member owner;

  private List<Contract> contractList = new ArrayList<>();

  public Item(String name) {
    this.itemName = name;
  }

  /**
   * this is Item constructor.
   */
  @SuppressFBWarnings
  public Item(String category, String itemName, String description, int creationDate, int cost, boolean lendStatus,
      Member owner) {
    this.category = category;
    this.itemName = itemName;
    this.description = description;
    this.creationDate = creationDate;
    this.cost = cost;
    this.lendStatus = lendStatus;
    this.owner = owner;
  }

  /**
   * this is Item constructor.
   */
  @SuppressFBWarnings
  public Item(String category, String itemName, String description, int creationDate, int cost, Member owner) {
    this.category = category;
    this.itemName = itemName;
    this.description = description;
    this.creationDate = creationDate;
    this.cost = cost;
    this.owner = owner;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemName() {
    return itemName;
  }

  public void setdescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setCreationDate(int creationDate) {
    this.creationDate = creationDate;
  }

  public int getCreationDate() {
    return creationDate;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }

  public void setLendStatus(boolean lendStatus) { // true means lent, false means available
    this.lendStatus = lendStatus;
  }

  public boolean getLendStatus() {
    return lendStatus;
  }

  @SuppressFBWarnings
  public void setOwner(Member owner) {
    this.owner = owner;
  }

  @SuppressFBWarnings
  public Member getOwner() {
    return owner;
  }

  /**
   * Return a list of contracts in which the item is involved.
   */
  @SuppressFBWarnings
  public Iterable<Contract> getContracts() {
    return contractList;
  }

  /**
   * Check if a new contract can be created.
   */
  public Boolean itemAvailablility(int lendingStartDate, int lendingEndDate) {
    for (Contract c : contractList) {
      if (lendingStartDate <= lendingEndDate) {
        if (lendingEndDate < c.getStartDate() || lendingStartDate > c.getEndDate()) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * add contract to contract list.
   */
  public void addContract(Contract contract) {
    contractList.add(contract);

  }

  /**
   * Target at a contract at a specific time.
   */
  public Contract getContractByDate(int currentTime) {
    for (Contract contract : contractList) {
      int startDate = contract.getStartDate();
      int endDate = contract.getEndDate();
      if (currentTime >= startDate && currentTime <= endDate) {
        return contract;
      }
    }

    return null;
  }

  /**
   * Get a lender by name.
   */
  public Member getLenderByName(String name) {
    for (Contract contract : contractList) {
      if (name.equals(contract.getLenderName())) {
        return contract.getLender();
      }
    }
    return null;
  }

  /**
   * Get contract object by lender.
   */
  public Contract getContractByLender(Member lender) {
    for (Contract contract : contractList) {
      if (lender == contract.getLender()) {
        return contract;
      }
    }
    return null;
  }

}