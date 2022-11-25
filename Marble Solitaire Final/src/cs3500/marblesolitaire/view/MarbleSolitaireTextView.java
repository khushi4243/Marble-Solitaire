package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class helps to display the board, and contains methods which help in its visualization.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  protected MarbleSolitaireModelState state;
  protected Appendable app;

  /**
   * This displays the board on the screen.
   *
   * @param state an object which represents the board object
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) {
    if (state == null) {
      throw new IllegalArgumentException("Provided model is null");
    }
    this.state = state;
    this.app = System.out;
  }

  /**
   * This constructor takes in an appendable and MarbleSolitaireModelState and displays the baord on
   * the screen.
   *
   * @param state this repesents the board state
   * @param app   this represents the appendable which allows you to append
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable app) {
    if (state == null || app == null) {
      throw new IllegalArgumentException("objects are null");
    }
    this.state = state;
    this.app = app;
  }

  /**
   * This method prints the board as a string according to its various states.
   *
   * @return a String of the board.
   */
  @Override
  public String toString() {
    StringBuilder board = new StringBuilder();
    int armThickness = (state.getBoardSize() + 2) / 3;
    for (int i = 0; state.getBoardSize() > i; i++) {
      for (int j = 0; state.getBoardSize() > j; j++) {
        if (this.state.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          board.append("_ ");
        }
        if (this.state.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          board.append("O ");
        }
        if (this.state.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid
                && j < this.state.getBoardSize() / 2) {
          board.append("  ");
        }
      }
      board.deleteCharAt(board.length() - 1);
      if (i != board.length() - 1) {
        board.append("\n");
      }
    }
    return board.substring(0, board.length() - 1);
  }

  @Override
  public void renderBoard() throws IOException {
    app.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    app.append(message);
  }
}

