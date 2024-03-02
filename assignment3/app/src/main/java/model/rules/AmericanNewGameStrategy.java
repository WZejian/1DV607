package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  public boolean newGame(Deck deck, Dealer dealer, Player player) {

    dealer.getNewCard(dealer, true);
    dealer.getNewCard(player, true);
    dealer.getNewCard(dealer, false);
    dealer.getNewCard(player, true);

    return true;
  }
}