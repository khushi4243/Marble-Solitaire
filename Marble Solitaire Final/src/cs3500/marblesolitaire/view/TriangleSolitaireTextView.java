package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This displays the board on the screen for the triangle model.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * This displays the board on the screen.
   *
   * @param state an object which represents the board object
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state) {
    super(state, System.out);
  }

  /**
   * This constructor takes in an appendable and MarbleSolitaireModelState and displays the baord on
   * the screen.
   *
   * @param state this repesents the board state
   * @param app   this represents the appendable which allows you to append
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable app) {
    super(state, app);
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
    for (int row = 0; row < state.getBoardSize(); row++) {
      for (int i = 0; i < state.getBoardSize() - row - 1; i++) {
        board.append(" ");
      }
      for (int col = 0; state.getBoardSize() > col; col++) {
        if (this.state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
          board.append("_ ");
        }
        if (this.state.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
          board.append("O ");
        }
      }
      board.deleteCharAt(board.length() - 1);
      if (row != board.length() - 1) {
        board.append("\n");
      }
    }
    return board.substring(0, board.length() - 1);
  }

}

