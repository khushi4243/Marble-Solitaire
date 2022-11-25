package cs3500.marblesolitaire.controller;

/**
 * This represents the controller for the game, which communicates with the model and view.
 */
public interface MarbleSolitaireController {
  /**
   * plays a new game of Marble Solitaire.
   */
  void playGame() throws IllegalStateException;
}
