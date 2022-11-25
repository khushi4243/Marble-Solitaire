import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

class MarbleSolitaireModelMock implements MarbleSolitaireModel {
  private StringBuilder log;

  MarbleSolitaireModelMock(StringBuilder log) {
    this.log = log;
  }

  @Override
  public int getBoardSize() {
    this.log.append("This calls getBoardSize(). \n");
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    this.log.append(String.format("This calls getSlotAt(%d, %d. \n", row, col));
    return null;
  }

  @Override
  public int getScore() {
    this.log.append("This calls getScore(). \n");
    return 0;
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.log.append(
            String.format("This calls move(%d, %d, %d, %d). \n", fromRow, fromCol, toRow, toCol));
  }

  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    this.log.append("This calls isGameOver(). \n");
    return false;
  }
}
