import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the methods in the English Solitaire Model class. It tests the methods relating
 * to the stsate of the board.
 */
public class EnglishSolitaireModelTest {
  private MarbleSolitaireModel board1;
  private MarbleSolitaireModel board2;
  private MarbleSolitaireModel board3;
  private MarbleSolitaireModel board4;
  private MarbleSolitaireModel board6;

  @Before
  public void initConditions() {
    this.board1 = new EnglishSolitaireModel();
    this.board2 = new EnglishSolitaireModel(4, 3);
    this.board3 = new EnglishSolitaireModel(3);
    this.board4 = new EnglishSolitaireModel(5);
    this.board6 = new EnglishSolitaireModel(5, 5, 5);
  }

  @Test
  public void getScore() {
    assertEquals(32, this.board1.getScore());
    assertEquals(32, this.board2.getScore());
    assertEquals(104, this.board4.getScore());
    assertEquals(104, this.board6.getScore());
  }

  @Test
  public void getBoardSize() {
    assertEquals(7, this.board1.getBoardSize());
    assertEquals(7, this.board2.getBoardSize());
    assertEquals(7, this.board3.getBoardSize());
    assertEquals(13, this.board6.getBoardSize());
  }


  @Test
  public void getSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board1.getSlotAt(0, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board2.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board2.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board2.getSlotAt(4, 3));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board4.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board4.getSlotAt(0, 0));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board6.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board6.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board4.getSlotAt(1, 0));
  }

  @Test
  public void testBelowMove() {
    board1.move(5, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(3, 3));
  }

  @Test
  public void testAboveMove() {
    board1.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(2, 3));
  }

  @Test
  public void testRightMove() {
    board1.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(3, 1));
  }

  @Test
  public void testLeftMove() {
    board1.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(3, 4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty1() {
    new EnglishSolitaireModel(4, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty2() {
    new EnglishSolitaireModel(-3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty3() {
    new EnglishSolitaireModel(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmptyConstructor2() {
    new EnglishSolitaireModel(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmptyConstructor4() {
    new EnglishSolitaireModel(3, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void PositiveOddConstructor2() {
    new EnglishSolitaireModel(6, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void PositiveOddConstructor1() {
    board1.move(3, 4, -7, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toNotExistConstructor1() {
    board1.move(3, 4, -7, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toNotExistConstructor2() {
    board2.move(3, 2, 5, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toNotExistConstructor3() {
    board3.move(6, 2, 8, -6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void toNotExistConstructor4() {
    board6.move(5, 7, 3, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNotExistConstructor1() {
    board1.move(5, -3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNotExistConstructor2() {
    board2.move(-4, 6, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNotExistConstructor3() {
    board3.move(2, -6, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNotExistConstructor4() {
    board6.move(-4, 2, 6, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleFromConstructor1() {
    board1.move(0, 0, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleFromConstructor2() {
    board2.move(1, 1, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleFromConstructor3() {
    board4.move(1, 1, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleFromConstructor4() {
    board6.move(2, 1, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonEmptyToConstructor1() {
    board2.move(3, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonEmptyToConstructor2() {
    board2.move(3, 4, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void jumpEmptySlotConstructor1() {
    board2.move(3, 2, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void jumpEmptySlotConstructor2() {
    board2.move(4, 2, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moreThanTwoPositions() {
    board2.move(4, 2, 4, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalConstructor1() {
    board1.move(4, 3, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void diagonalConstructor3() {
    board1.move(4, 3, 2, 4);
  }


  @Test
  public void isGameOver_board1() {
    assertEquals(false, board1.isGameOver());
  }

  @Test
  public void isGameOver_board2() {
    assertEquals(false, board2.isGameOver());
  }

  @Test
  public void isGameOver_board3() {
    assertEquals(false, board4.isGameOver());
  }

  @Test
  public void isGameOver_board4() {
    assertEquals(false, board6.isGameOver());
  }

  @Test
  public void isGameOver_True() {
    board1.move(3, 1, 3, 3);
    board1.move(5, 2, 3, 2);
    board1.move(4, 0, 4, 2);
    board1.move(4, 3, 4, 1);
    board1.move(4, 5, 4, 3);
    board1.move(6, 4, 4, 4);
    board1.move(3, 4, 5, 4);

    board1.move(6, 2, 6, 4);
    board1.move(6, 4, 4, 4);
    board1.move(2, 2, 4, 2);
    board1.move(0, 2, 2, 2);

    board1.move(1, 4, 3, 4);
    board1.move(3, 4, 5, 4);
    board1.move(5, 4, 5, 2);
    board1.move(5, 2, 3, 2);
    board1.move(3, 2, 1, 2);

    board1.move(2, 0, 4, 0);
    board1.move(4, 0, 4, 2);
    board1.move(4, 2, 4, 4);

    board1.move(2, 6, 2, 4);
    board1.move(2, 3, 2, 5);

    board1.move(4, 6, 2, 6);
    board1.move(2, 6, 2, 4);
    board1.move(0, 4, 0, 2);
    board1.move(0, 2, 2, 2);

    board1.move(2, 1, 2, 3);
    board1.move(2, 3, 2, 5);
    board1.move(2, 5, 4, 5);
    board1.move(4, 5, 4, 3);
    board1.move(4, 3, 2, 3);

    board1.move(1, 3, 3, 3);

    assertEquals(true, board1.isGameOver());


  }


}