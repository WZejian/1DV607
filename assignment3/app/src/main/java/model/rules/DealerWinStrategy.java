package model.rules;

import model.Game;

class DealerWinStrategy implements WinStrategy {

  /**
   * True means dealer is winner.
   * False means player is winner.
   */
  public boolean isDealerWinner(Game g) {

    if (g.getDealerScore() <= 21) { 
      if (g.getDealerScore() >= g.getPlayerScore()) {
        return true; 
      }
    }

    return false;

  }

}
