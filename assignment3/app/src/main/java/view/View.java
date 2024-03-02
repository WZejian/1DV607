package view;

import model.Card.Mutable;
import view.EnglishView.Choice;

/**
 * Encapsulates the generic view functionality.
 */
public interface View {

  /**
   * Shows a welcome message.
   */
  void displayWelcomeMessage();

  Choice getChoices();

  /**
   * Returns pressed characters from the keyboard.
   * return the pressed character.
   */
  int getInput();

  /**
   * Displays a card.
   * param card The card to display.
   */
  void displayCard(model.Card card);

  /**
   * Displays the cards and score of the player.
   * param hand  the player's hand.
   * param score the player's score.
   */
  void displayPlayerHand(Iterable<Mutable> iterable);

  /**
   * Displays the cards and score of the dealer.
   * param hand  the dealer's score.
   * param score the players's score.
   */
  void displayDealerHand(Iterable<Mutable> iterable);

  /**
   * Displays the winner of the game.
   * param dealerIsWinner True if the dealer is the winner.
   */
  void displayGameOver(boolean dealerIsWinner);

  void pause();

  void printPalyerScore(int score);

  void printDealererScore(int score);

}