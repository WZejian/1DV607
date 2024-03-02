package view;

import view.EnglishView.Choice;

/**
 * Implements a Swedish console view.
 */
public class SwedishView implements View {

  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }

    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
    System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
  }

  /**
   * användning av emuration som skaped i englishview.
   */
  public Choice getChoices() {
    while (true) {
      int c = getInput();
      if (c == 'p') {
        return Choice.Play;
      } else if (c == 'q') {
        return Choice.Quit;
      } else if (c == 'h') {
        return Choice.Hit;
      } else if (c == 's') {
        return Choice.Stand;
      }
    }
  }

  /**
   * Returns pressed characters from the keyboard.
   * return the pressed character.
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

  /**
   * Displays a card.
   * param card The card to display.
   */
  public void displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("Dolt Kort");
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio",
          "knekt", "dam", "kung", "ess" };
      System.out.println("" + colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()]);
    }
  }

  public void displayPlayerHand(Iterable<model.Card.Mutable> hand) {
    displayHand("Spelare", hand);
  }

  public void displayDealerHand(Iterable<model.Card.Mutable> hand) {
    displayHand("Croupier", hand);
  }

  /**
   * Displays the winner of the game.
   * param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("Croupiern Vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  private void displayHand(String name, Iterable<model.Card.Mutable> hand) {
    // System.out.println(name + " Har: " +);
    for (model.Card c : hand) {
      displayCard(c);
    }
    // System.out.println("Poäng: " + score);
    System.out.println("");
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
    System.out.println("Player has " + score);

  }

  @Override
  public void printDealererScore(int score) {
    System.out.println("Dealer has " + score);

  }

}
