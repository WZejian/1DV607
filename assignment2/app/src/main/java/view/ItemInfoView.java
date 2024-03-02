package view;

import com.google.common.collect.Lists;
import model.Contract;
import model.Item;

/**
 * A view for item-related info.
 */
public class ItemInfoView {


  /**
   * This method is built for the convenience of print out info of all members.
   */
  public String itemBasicInfo(Item item) {

    String itemBasicInfo = "\nItem name: " + item.getItemName();
    itemBasicInfo += "\nOwner-- Name: " + item.getOwner().getName() + ", ID: " + item.getOwner().getId();
    itemBasicInfo += "\nCategory-- " + item.getCategory();
    itemBasicInfo += "\nDescription-- " + item.getDescription();
    itemBasicInfo += "\nCreated on-- Day " + item.getCreationDate();
    itemBasicInfo += "\nCost for lending-- " + item.getCost() + " credits/day.\n";
    
    return itemBasicInfo;
  }

  /**
   * Make an item's information to a string.
   */
  public String itemFullInfo(Item item) {
    
    ContractInfoView cv = new ContractInfoView();
    String itemFullInfo = itemBasicInfo(item);
    itemFullInfo += "\nContracts involved: ";
    
    Iterable<Contract> contractList = item.getContracts();

    String contractsInfo = "";
    int contractOrder = 0;

    for (Contract contract : contractList) {
      contractOrder += 1;
      contractsInfo += "\n---------------------Contract " + contractOrder + "-------------------------";
      contractsInfo += cv.contractInfo(contract);
    }

    if (Lists.newArrayList(contractList).size() == 0) {
      itemFullInfo += "\nNo contract involving the item so far.";
    }

    itemFullInfo += contractsInfo;

    return itemFullInfo;
  }

  


  
}
