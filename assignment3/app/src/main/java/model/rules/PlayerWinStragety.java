package model.rules;

import model.Game;

class PlayerWinStragety implements WinStrategy {

  /**
   * False means player is winner.
   * True means dealer is winner.
   */
  public boolean isDealerWinner(Game g) {

    if (g.getPlayerScore() <= 21) { 
      if (g.getPlayerScore() >= g.getDealerScore()) {
        return false; 
      }
    }

    return true;

  }

}
