package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This represents the abstract class for all 3 types of marble solitaire games.
 */
public abstract class MarbleSolitaireModelAbstract implements MarbleSolitaireModel {
  protected SlotState[][] board;
  protected int score;

  protected int armThickness;

  /**
   * Allows you to set all 3 parameters and calls the method which creates the board.
   *
   * @param armThickness this represents the length of the board until the center point
   * @param row          the row of the position sought, starting at 0
   * @param col          the column of the position sought, starting at 0
   */
  public MarbleSolitaireModelAbstract(int armThickness, int row, int col) {
    this.armThickness = armThickness;
    this.makeBoard(armThickness, row, col);
    if (!isValidSpace(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row + "," + col + ")");
    }
  }

  /**
   * This method instantiates the board as an array.
   *
   * @param armThickness this represents the length of the board until the center point
   * @param col          the column of the position sought, starting at 0
   * @param row          the row of the position sought, starting at 0
   */
  protected abstract void makeBoard(int armThickness, int row, int col);

  /**
   * Checks to see if the given move is able to be made.
   *
   * @param fromRow the row number of the position to be moved from *                (starts at 0)
   * @param fromCol the column number of the position to be moved from *                (starts at
   *                0)
   * @param toRow   the row number of the position to be moved to *                (starts at 0)
   * @param toCol   the column number of the position to be moved to *                (starts at 0)
   * @return whether the move made is valid
   */
  protected abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * This checks to see if it is within the bounds of the board.
   *
   * @param col the column of the position sought, starting at 0
   * @param row the row of the position sought, starting at 0
   * @return whether it is within the bounds of the board
   */
  protected abstract boolean isInBounds(int row, int col);

  /**
   * Checks to see if the space is within the bounds of the board.
   *
   * @param sRow the row of the position sought, starting at 0
   * @param sCol the column of the position sought, starting at 0
   * @return whether the space is valid
   */
  protected abstract boolean isValidSpace(int sRow, int sCol);

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
  public abstract void move(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * Checks to see whether no more valid moves can be made.
   *
   * @return whether the game is over
   */
  public abstract boolean isGameOver();

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */

  public int getBoardSize() {
    return this.board.length;
  }

  /**
   * This provides the SlotState according to the position.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return either Invalid, Marble, or Empty
   * @throws IllegalArgumentException when the row and column input is not a valid space
   */
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (!isInBounds(row, col)) {
      System.out.println(row + " " + col);
      throw new IllegalArgumentException("Not valid space");
    }
    return this.board[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */

  public int getScore() {
    return this.score;
  }
}
