package controller;


/**
 * Responsible for staring the application.
 */
public class App {


  /**
   * Application starting point.
   */
  public static void main(String[] args) {

    LendingManagement lm = new LendingManagement();
    lm.doMainMenu();
  }
}
