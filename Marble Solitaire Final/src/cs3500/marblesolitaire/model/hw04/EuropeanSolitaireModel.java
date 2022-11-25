package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents a EuropeanSolitaireModel.
 */
public class EuropeanSolitaireModel extends MarbleSolitaireModelAbstract {
  /**
   * This constructor is the default constructor which sets all 3 parameters.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * This allows you to set an arbitrary armThickness while keeping the empty at the middle.
   *
   * @param armThickness this represents the length of the board until the center point
   */
  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  /**
   * This allows one to set an abritrary row and column.
   *
   * @param sRow the row of the position sought, starting at 0
   * @param sCol the column of the position sought, starting at 0
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Allows you to set all 3 parameters and calls the method which creates the board.
   *
   * @param armThickness this represents the length of the board until the center point
   * @param sRow         the row of the position sought, starting at 0
   * @param sCol         the column of the position sought, starting at 0
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
  }

  /**
   * This method instantiates the board as an array.
   *
   * @param armThickness this represents the length of the board until the center point
   * @param sRow         the row of the position sought, starting at 0
   * @param sCol         the column of the position sought, starting at 0
   */
  protected void makeBoard(int armThickness, int sRow, int sCol) {
    if (armThickness <= 2 || armThickness % 2 == 0 || sRow < 0 || sCol < 0) {
      throw new IllegalArgumentException("Arm thickness must be positive and odd number");
    }
    this.score = 0;
    this.board = new SlotState[3 * armThickness - 2][3 * armThickness - 2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (i >= armThickness - 1 - j && i <= 2 * armThickness - 2 + j) {
          this.board[i][j] = SlotState.Marble;
          score++;
        } else {
          this.board[i][j] = SlotState.Invalid;
        }
      }
      for (int j = ((3 * armThickness) - 2) / 2; j < board.length; j++) {
        if (i >= -2 * armThickness + 2 + j && i <= 5 * armThickness - 5 - j) {
          this.board[i][j] = SlotState.Marble;
        } else {
          this.board[i][j] = SlotState.Invalid;
          score--;
        }
      }
    }
    if (isValidSpace(sRow, sCol)) {
      this.score--;
      this.board[sRow][sCol] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Non valid space.");
    }

  }

  /**
   * Checks to see if the space is within the bounds of the board.
   *
   * @param sRow the row of the position sought, starting at 0
   * @param sCol the column of the position sought, starting at 0
   * @return whether the space is valid
   */
  protected boolean isValidSpace(int sRow, int sCol) {
    if (isInBounds(sRow, sCol)) {
      return this.board[sRow][sCol] != MarbleSolitaireModelState.SlotState.Invalid;
    }
    return false;
  }

  protected boolean isInBounds(int row, int col) {
    return (row >= 0 && row < 3 * armThickness - 2 && col < 3 * armThickness - 2 && col >= 0);
  }

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
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return isValidSpace(fromRow, fromCol) && isValidSpace(toRow, toCol) && (
            this.board[fromRow][fromCol] == MarbleSolitaireModelState.SlotState.Marble) && (
            this.board[toRow][toCol]
                    == MarbleSolitaireModelState.SlotState.Empty) && (
            (Math.abs(toRow - fromRow) == 2 && toCol - fromCol == 0) || (
                    Math.abs(toCol - fromCol) == 2 && toRow - fromRow == 0)) && (
            this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
                    == MarbleSolitaireModelState.SlotState.Marble);

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
    if (!isValidSpace(fromRow, fromCol) || (!isValidSpace(toRow, toCol))) {
      throw new IllegalArgumentException("To and from positions are not valid");
    }
    if (this.board[fromRow][fromCol] != MarbleSolitaireModelState.SlotState.Marble) {
      throw new IllegalArgumentException("there is no marble at the specified from position");
    }
    if (this.board[toRow][toCol] != MarbleSolitaireModelState.SlotState.Empty) {
      throw new IllegalArgumentException("The to position is not empty");
    }
    if ((Math.abs(toRow - fromRow) != 2 || toCol != fromCol) && (Math.abs(toCol - fromCol) != 2
            || toRow != fromRow)) {
      throw new IllegalArgumentException("not two spaces away");
    }
    if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
            != MarbleSolitaireModelState.SlotState.Marble) {
      throw new IllegalArgumentException("No marble in the middle");
    }
    this.board[fromRow][fromCol] = MarbleSolitaireModelState.SlotState.Empty;
    this.board[toRow][toCol] = MarbleSolitaireModelState.SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] =
            MarbleSolitaireModelState.SlotState.Empty;
    this.score--;
  }


  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.board.length;
  }


  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    return this.score;
  }

  /**
   * Checks to see whether no more valid moves can be made.
   *
   * @return whether the game is over
   */
  public boolean isGameOver() {
    for (int i = 0; this.board.length > i; i++) {
      for (int j = 0; this.board.length > j; j++) {
        if (isValidMove(i, j, i, j + 2)
                || isValidMove(i, j, i, j - 2)
                || isValidMove(i, j, i + 2, j)
                || isValidMove(i, j, i - 2, j)) {
          return false;
        }
      }
    }
    return true;
  }
}
