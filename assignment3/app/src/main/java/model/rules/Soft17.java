package model.rules;

import model.Card;
import model.Player;

/**
 * Implemented soft 17 rule for the dealer.
 */
public class Soft17 implements HitStrategy {

  private static final int hitLimit = 17;

  /**
   * doHit for the soft 17 rule.
   */
  @Override
  public boolean doHit(Player dealer) {

    if (dealer.calcScore() < hitLimit) {
      return true;
    } else if (dealer.calcScore() == hitLimit) {
      Player dealerCopy = new Player();
      for (Card.Mutable card : dealer.getHand()) {
        dealerCopy.dealCard(card);
      }
      Card.Mutable king = new Card.Mutable(Card.Color.Hearts, Card.Value.King);
      dealerCopy.dealCard(king);
      if (dealerCopy.calcScore() == hitLimit) {
        return true;
      }
    }
    return false;
  }
}
