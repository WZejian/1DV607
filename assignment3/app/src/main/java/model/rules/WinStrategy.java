package model.rules;

import model.Game;

/**
 * Gives two versions of winstrategy.
 */
public interface WinStrategy {

  boolean isDealerWinner(Game game); 

}
