package view;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {

  final char[] chars = { 'p', 'h', 's', 'q' };

  /**
   * emuration for choices.
   */
  public enum Choice {
    Play,
    Hit,
    Stand,
    Quit
  }

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 10; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out
        .println("Type '" + chars[0] + "' to " + Choice.Play + ", '" + chars[1] + "' to " + Choice.Hit + ", '"
            + chars[2] + "' to " + Choice.Stand + " or '"
            + chars[3] + "' to " + Choice.Quit + "\n");
  }

  /**
   * take input to do event.
   */
  public Choice getChoices() {
    while (true) {
      int c = getInput();
      if (c == chars[0]) {
        return Choice.Play;
      } else if (c == chars[1]) {
        return Choice.Hit;
      } else if (c == chars[2]) {
        return Choice.Stand;
      } else if (c == chars[3]) {
        return Choice.Quit;
      }
    }
  }

  /**
   * Returns pressed characters from the keyboard.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("  " + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card.Mutable> hand) {
    displayHand("Player", hand);
  }

  public void displayDealerHand(Iterable<model.Card.Mutable> hand) {
    displayHand("Dealer", hand);
  }

  private void displayHand(String name, Iterable<model.Card.Mutable> hand) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    // System.out.println(" Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.
   * DealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }
  }

  @Override
  public void pause() {
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void printPalyerScore(int score) {
    System.out.println("Player's score: " + score);

  }

  @Override
  public void printDealererScore(int score) {
    System.out.println("Dealer's score: " + score);

  }

}
