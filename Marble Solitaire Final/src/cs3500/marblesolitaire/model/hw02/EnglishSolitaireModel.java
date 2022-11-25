package cs3500.marblesolitaire.model.hw02;

/*


    O O O
    O O O
O O O O O O O
O O O _ O O O
O O O O O O O
    O O O
    O O O

 */

import cs3500.marblesolitaire.model.hw04.MarbleSolitaireModelAbstract;

/**
 * This class creates the board that will be used for the game. It containes methods which aid in
 * the creation of the board.
 */
public class EnglishSolitaireModel extends MarbleSolitaireModelAbstract
        implements MarbleSolitaireModel {
  /**
   * This constructor is the defeault constructor.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * This allows one to set an abritrary row and column.
   *
   * @param sRow the row of the position sought, starting at 0
   * @param sCol the column of the position sought, starting at 0
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * This allows you to set an arbitrary armThickness while keeping the empty at the middle.
   *
   * @param armThickness this represents the length of the board until the center point
   */
  public EnglishSolitaireModel(int armThickness) {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  /**
   * Allows you to set all 3 parameters and calls the method which creates the board.
   *
   * @param armThickness this represents the length of the board until the center point
   * @param sRow         the row of the position sought, starting at 0
   * @param sCol         the column of the position sought, starting at 0
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
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
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board.length; j++) {
        if ((i < armThickness - 1 || i > 2 * armThickness - 2) && (j < armThickness - 1
                || j > 2 * armThickness - 2)) {
          this.board[i][j] = SlotState.Invalid;
        } else {
          this.board[i][j] = SlotState.Marble;
          this.score++;
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
   * Adds 1 every time the the user scores a point on the board.
   *
   * @return the score number
   */
  public int getScore() {
    return this.score;
  }

  /**
   * This methods returns the size of the baord.
   *
   * @return the length of the board
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
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (!isInBounds(row, col)) {
      throw new IllegalArgumentException("Not valid space");
    }
    return this.board[row][col];
  }


  /**
   * Moves the marbles on the baord.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException when the to and from positions are not valid, there is no
   *                                  marble in the from positon, the to position is empty, the to
   *                                  and from positions are not two spaces away, and there is no
   *                                  marble in the middle
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!isValidSpace(fromRow, fromCol) || (!isValidSpace(toRow, toCol))) {
      throw new IllegalArgumentException("To and from positions are not valid");
    }
    if (this.board[fromRow][fromCol] != SlotState.Marble) {
      throw new IllegalArgumentException("there is no marble at the specified from position");
    }
    if (this.board[toRow][toCol] != SlotState.Empty) {
      throw new IllegalArgumentException("The to position is not empty");
    }
    if ((Math.abs(toRow - fromRow) != 2 || toCol != fromCol) && (Math.abs(toCol - fromCol) != 2
            || toRow != fromRow)) {
      throw new IllegalArgumentException("not two spaces away");
    }
    if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] != SlotState.Marble) {
      throw new IllegalArgumentException("No marble in the middle");
    }
    this.board[fromRow][fromCol] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
    this.score--;
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
      return this.board[sRow][sCol] != SlotState.Invalid;
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
            this.board[fromRow][fromCol] == SlotState.Marble) && (this.board[toRow][toCol]
            == SlotState.Empty) && ((Math.abs(toRow - fromRow) == 2 && toCol - fromCol == 0) || (
            Math.abs(toCol - fromCol) == 2 && toRow - fromRow == 0)) && (
            this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] == SlotState.Marble);

  }

  /**
   * Checks to see whether no more valid moves can be made.
   *
   * @return whether the game is over
   */
  @Override
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

