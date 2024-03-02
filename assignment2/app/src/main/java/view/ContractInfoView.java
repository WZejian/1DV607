package view;

import model.Contract;

/**
 * A view for contract-related info.
 */
public class ContractInfoView {

  /**
   * Make contract information to a string.
   */
  public String contractInfo(Contract contract) {

    String contractInfoString = "";
    contractInfoString += "\nLending item name-- " + contract.getItem().getItemName();
    contractInfoString += "\nParties Involved:\n  Owner-- Name: " + contract.getItem().getOwner().getName() + ", ID: "
        + contract.getItem().getOwner().getId();
    contractInfoString += "\n  Lender-- Name: " + contract.getLender().getName() + ", ID: "
        + contract.getLender().getId();
    contractInfoString += "\nLending Period:\n " + "  Day " + contract.getStartDate() + " to Day "
        + contract.getEndDate();
    return contractInfoString;
  }

  /**
   * Shows a contract's info.
   */
  public void showContractInfo(Contract contract) {
    System.out.println(contractInfo(contract));
  }
}
