package controller;

import model.Game;
import model.Observer;
import view.View;

/**
 * Scenario controller for playing the game.
 */
public class Player implements Observer {

  private Game game;
  private View view;
  protected static final int pause = 1500;

  /**
   * Creates a player object.
   */
  public Player(Game game, View view) {
    this.game = game;
    this.view = view;
    game.attach(this);
  }

  /**
   * Runs the play use case.
   */
  public boolean play() {

    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand());
    view.displayPlayerHand(game.getPlayerHand());

    view.printDealererScore(game.getDealerScore());
    view.printPalyerScore(game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    switch (view.getChoices()) {
      case Play:
        game.newGame();
        break;

      case Hit:
        game.hit();
        break;

      case Stand:
        game.stand();
        break;

      case Quit:
        return false;

      default:
        break;
    }

    return true;
  }

  /**
   * Be notified to update. i.e.display the dealing card and its total score.
   */
  @Override
  public void update() {
    view.displayPlayerHand(game.getPlayerHand());
    view.pause();
    view.displayDealerHand(game.getDealerHand());
    view.pause();
  }
}