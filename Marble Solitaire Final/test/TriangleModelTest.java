import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * This tests the triangle model.
 */
public class TriangleModelTest {
  private MarbleSolitaireModel board1;
  private MarbleSolitaireModel board2;
  private MarbleSolitaireModel board3;
  private MarbleSolitaireModel board4;

  private MarbleSolitaireModel board5;
  private MarbleSolitaireModel board6;

  @Before
  public void initConditions() {
    this.board1 = new TriangleSolitaireModel();
    this.board2 = new TriangleSolitaireModel(2, 1);
    this.board3 = new TriangleSolitaireModel(7);
    this.board4 = new TriangleSolitaireModel(5, 4, 2);
    this.board5 = new TriangleSolitaireModel(7, 1, 0);
    this.board6 = new TriangleSolitaireModel(7, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty1() {
    new TriangleSolitaireModel(3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty2() {
    new TriangleSolitaireModel(-3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty3() {
    new TriangleSolitaireModel(-3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidEmpty4() {
    new TriangleSolitaireModel(3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidDimension() {
    new TriangleSolitaireModel(2, 2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidDimension1() {
    new TriangleSolitaireModel(1, 2, 1);
  }

  @Test
  public void getScore() {
    assertEquals(14, this.board1.getScore());
    assertEquals(14, this.board2.getScore());
    assertEquals(27, this.board3.getScore());
    assertEquals(14, this.board4.getScore());
  }

  @Test
  public void getBoardSize() {
    assertEquals(5, this.board1.getBoardSize());
    assertEquals(5, this.board2.getBoardSize());
    assertEquals(7, this.board3.getBoardSize());
    assertEquals(5, this.board4.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(0, 0));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board2.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board2.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board2.getSlotAt(2, 1));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board3.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board3.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board3.getSlotAt(0, 0));

    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.board4.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board4.getSlotAt(3, 0));
  }

  @Test
  public void testAboveMove() {
    board1.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board1.getSlotAt(0, 0));
  }

  @Test
  public void testBelowMove() {
    board4.move(2, 2, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board4.getSlotAt(4, 2));
  }

  @Test
  public void testRightMove() {
    board4.move(4, 0, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board4.getSlotAt(4, 2));
  }

  @Test
  public void testLeftMove() {
    board4.move(4, 4, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board4.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board4.getSlotAt(4, 2));
  }

  @Test
  public void testDiagonalAbove() {
    board5.move(3, 2, 1, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board5.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board5.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board5.getSlotAt(1, 0));
  }

  @Test
  public void testDiagonalBelow() {
    board6.move(2, 1, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board6.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.board6.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.board6.getSlotAt(4, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidFromConstructor1() {
    board1.move(1, 3, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidFromConstructor4() {
    board6.move(4, 5, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleFromConstructor4() {
    board5.move(1, 0, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void noMarbleFromConstructor2() {
    board5.move(2, 1, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void jumpEmptyConstructor2() {
    board2.move(1, 0, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void jumpEmptyConstructor4() {
    board6.move(3, 2, 5, 4);
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
    assertEquals(false, board3.isGameOver());
  }

  @Test
  public void isGameOver_board4() {
    assertEquals(false, board1.isGameOver());
  }

  @Test
  public void isGameOver_false() {
    board4.move(4, 4, 4, 2);
    board4.move(4, 1, 4, 3);
    board4.move(2, 1, 4, 1);
    board4.move(2, 2, 4, 2);
    board4.move(4, 2, 4, 4);
    board4.move(4, 4, 2, 2);
    board4.move(1, 1, 3, 3);
    board4.move(4, 0, 4, 2);
    board4.move(2, 0, 4, 0);
    assertEquals(false, board4.isGameOver());
  }


  @Test
  public void isGameOver_true() {
    board4.move(4, 4, 4, 2);
    board4.move(4, 1, 4, 3);
    board4.move(2, 1, 4, 1);
    board4.move(2, 2, 4, 2);
    board4.move(4, 2, 4, 4);
    board4.move(4, 4, 2, 2);
    board4.move(1, 1, 3, 3);
    board4.move(4, 0, 4, 2);
    board4.move(2, 0, 4, 0);
    board4.move(0, 0, 2, 0);
    assertEquals(true, board4.isGameOver());
  }
}
