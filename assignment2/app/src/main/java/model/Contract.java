package model;

/**
 * This is contract class.
 */
public class Contract {

  public int startDate;
  public int endDate;
  public Item item;
  public Member lender;

  /**
   * Creates a contract object.
   */
  public Contract(int startDate, int endDate, Member lender) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.lender = lender;
    // item.addContract(this);
  }

  /**
   * Creates a contract object.
   */
  public Contract(int startDate, int endDate, Item item, Member lender) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.item = item;
    this.lender = lender;
    item.addContract(this);
    lender.addLentItem(item);
  }

  public void setStartDate(int startDate) {
    this.startDate = startDate;
  }

  public int getStartDate() {
    return startDate;
  }

  public void setEndDate(int endDate) {
    this.endDate = endDate;
  }

  public int getEndDate() {
    return endDate;
  }

  public void setLender(Member lender) {
    this.lender = lender;
  }

  public Member getLender() {
    return lender;
  }

  public String getLenderName() {
    return lender.getName();
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Item getItem() {
    return item;
  }

}
