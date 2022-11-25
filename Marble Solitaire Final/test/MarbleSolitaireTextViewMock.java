import java.io.IOException;

import cs3500.marblesolitaire.view.MarbleSolitaireView;

class MarbleSolitaireTextViewMock implements MarbleSolitaireView {
  private StringBuilder log;

  MarbleSolitaireTextViewMock(StringBuilder log) {
    this.log = log;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly in the
   * format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() {
    this.log.append("This calls renderBoard(). \n");
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) {
    this.log.append(String.format("This calls renderMessage(%s). \n", message));
  }
}
