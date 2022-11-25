package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This is the controller class which tells the model the moves to make.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Scanner scan;

  /**
   * This constructor instantiates the model, view, and scanner and throws an exception if either of
   * them are null.
   *
   * @param model This is a MarbleSolitaireModel object representing the state of the board
   * @param view  this is a MarbleSolitaireView object allowing us to view the board
   * @param read  this is a readable which allows us to read in inputs
   * @throws IllegalArgumentException when either model, view or readable are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable read) {
    if (model == null || view == null || read == null) {
      throw new IllegalArgumentException("Object(s) are null");
    }
    this.model = model;
    this.view = view;
    this.scan = new Scanner(read);
  }

  private void newLine(String s) {
    try {
      view.renderMessage(s + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("sending message failed");
    }
  }

  /**
   * This method allows us to play the game board which we created earlier.
   *
   * @throws IllegalStateException is there are any invalid moves
   */
  @Override
  public void playGame() throws IllegalStateException {
    try {

      if (model.isGameOver()) {
        newLine("Game over!");
        view.renderBoard();
        newLine("");
        newLine("Score: " + model.getScore());

        return;
      }

      view.renderBoard();
      newLine("");
      newLine("Score: " + model.getScore());


      int[] allInputs = new int[4];

      for (int i = 0; i < allInputs.length; i++) {
        if (scan.hasNext()) {
          String nextInput = scan.next();
          if (nextInput.toLowerCase().equals("q")) {
            newLine("Game quit!");
            newLine("State of game when quit:");
            view.renderBoard();
            newLine("");

            newLine("Score: " + model.getScore());
            return;
          } else {
            try {
              int num = Integer.parseInt(nextInput) - 1;
              allInputs[i] = num;
            } catch (IllegalArgumentException e) {
              newLine("Wrong input. Try again!");
              i--;
            }
          }
        } else {
          throw new IllegalStateException("No more inputs");
        }
      }
      try {
        model.move(allInputs[0], allInputs[1], allInputs[2], allInputs[3]);

      } catch (Exception e) {
        newLine("Invalid move. Play again. " + e.getMessage());
      }
      playGame();

    } catch (IOException e) {
      throw new IllegalStateException("sending message failed");
    }
  }
}
