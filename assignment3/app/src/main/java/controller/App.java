package controller;

import model.Game;
import view.EnglishView;
import view.View;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.
   */
  public static void main(String[] args) {

    Game g = new Game();
    View v = new EnglishView(); 
    Player ctrl = new Player(g, v);

    while (ctrl.play()) { 
    }
  }
}