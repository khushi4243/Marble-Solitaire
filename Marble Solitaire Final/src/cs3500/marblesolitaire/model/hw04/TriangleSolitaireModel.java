package cs3500.marblesolitaire.model.hw04;

/**
 * This represents the TriangleSolitaireModel game.
 */
public class TriangleSolitaireModel extends MarbleSolitaireModelAbstract {
  /**
   * This constructor is the default constructor which sets all 3 parameters.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * This allows you to set an arbitrary dimension while keeping the empty at the middle.
   *
   * @param dimensions this represents one side of the triangle
   */
  public TriangleSolitaireModel(int dimensions) {
    this(dimensions, 0, 0);
  }

  /**
   * This allows one to set an abritrary row and column.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   */
  public TriangleSolitaireModel(int row, int col) {
    this(5, row, col);
  }

  /**
   * Allows you to set all 3 parameters and calls the method which creates the board.
   *
   * @param dimensions this represents the length of the board until the center point
   * @param row        the row of the position sought, starting at 0
   * @param col        the column of the position sought, starting at 0
   */
  public TriangleSolitaireModel(int dimensions, int row, int col) {
    super(dimensions, row, col);
  }

  /**
   * This checks to see if it is within the bounds of the board.
   *
   * @param col the column of the position sought, starting at 0
   * @param row the row of the position sought, starting at 0
   * @return whether it is within the bounds of the board
   */
  protected boolean isInBounds(int row, int col) {
    return (row >= 0 && col >= 0 && row < board.length && col < board.length);
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
    return ((isValidSpace(fromRow, fromCol) && isValidSpace(toRow, toCol))
            && (this.board[fromRow][fromCol] == SlotState.Marble)
            && (this.board[toRow][toCol] == SlotState.Empty)
            && ((Math.abs(toRow - fromRow) == 2 && toCol - fromCol == 0)
            || (Math.abs(toCol - fromCol) == 2 && toRow - fromRow == 0)
            || ((toRow - fromRow) == 2 && ((toCol - fromCol) == 2))
            || ((toRow - fromRow) == -2 && ((toCol - fromCol) == -2)))
            && (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
            == SlotState.Marble));
  }

  /**
   * This method instantiates the board as an array.
   *
   * @param dimensions this represents the length of the board until the center point
   * @param row        the row of the position sought, starting at 0
   * @param col        the column of the position sought, starting at 0
   */
  protected void makeBoard(int dimensions, int row, int col) {
    int maxFill = 0;
    this.score = 0;

    this.board = new SlotState[armThickness][armThickness];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (j > maxFill) {
          if (i == row && j == col) {
            throw new IllegalArgumentException("No empty in invalid space");
          } else {
            this.board[i][j] = SlotState.Invalid;
          }
        } else if (i == row && j == col) {
          if (j <= maxFill) {
            this.board[i][j] = SlotState.Empty;
          } else {
            throw new IllegalArgumentException("No empty in invalid space");
          }
        } else {
          this.board[i][j] = SlotState.Marble;
          this.score++;
        }
      }
      maxFill++;
    }
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
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidSpace(fromRow, fromCol) || (!isValidSpace(toRow, toCol))) {
      throw new IllegalArgumentException("To and from positions are not valid");
    }
    if (this.board[fromRow][fromCol] != SlotState.Marble) {
      throw new IllegalArgumentException("there is no marble at the specified from position");
    }
    if (this.board[toRow][toCol] != SlotState.Empty) {
      throw new IllegalArgumentException("The to position is not empty");
    }
    if ((Math.abs(toRow - fromRow) != 2 || toCol != fromCol)
            && (Math.abs(toCol - fromCol) != 2 || toRow != fromRow)
            && ((toRow - fromRow != 2) || (toCol - fromCol != 2))
            && ((toRow - fromRow != -2) || (toCol - fromCol != -2))) {
      throw new IllegalArgumentException("not two spaces away");
    }
    if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2]
            != SlotState.Marble) {
      throw new IllegalArgumentException("No marble in the middle");
    }
    this.board[fromRow][fromCol] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] =
            SlotState.Empty;
    this.score--;
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
                || isValidMove(i, j, i - 2, j)
                || isValidMove(i, j, i + 2, j + 2)
                || isValidMove(i, j, i - 2, j - 2)) {
          return false;
        }
      }
    }
    return true;
  }
}

