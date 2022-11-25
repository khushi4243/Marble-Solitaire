import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * This tests the Triangle text view, or the display of the board.
 */
public class TriangleSolitaireTextViewTest {
  private MarbleSolitaireModel board1;
  private MarbleSolitaireModel board2;
  private MarbleSolitaireModel board3;

  private MarbleSolitaireModel board4;
  private MarbleSolitaireModel board5;
  private MarbleSolitaireModel board6;
  private MarbleSolitaireView view3;


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
  public void nullObject() {
    new TriangleSolitaireTextView(null);
  }

  @Test
  public void testToString() {
    MarbleSolitaireView view1 = new TriangleSolitaireTextView(board1);
    MarbleSolitaireView view2 = new TriangleSolitaireTextView(board2);
    MarbleSolitaireView view3 = new TriangleSolitaireTextView(board4);
    MarbleSolitaireView view4 = new TriangleSolitaireTextView(board5);

    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", view1.toString());
    assertEquals("    O\n"
            + "   O O\n"
            + "  O _ O\n"
            + " O O O O\n"
            + "O O O O O", view2.toString());

    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O _ O O", view3.toString());
    assertEquals("      O\n"
            + "     _ O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", view4.toString());
  }

  @Test
  public void testMoveToString() {
    MarbleSolitaireView view1 = new TriangleSolitaireTextView(board6);
    board6.move(2, 1, 4, 3);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O _ O\n"
            + "   O O _ O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", view1.toString());
  }

  @Test
  public void testMoveToString2() {
    view3 = new TriangleSolitaireTextView(board5);
    board5.move(3, 0, 1, 0);
    assertEquals("      O\n"
            + "     O O\n"
            + "    _ O O\n"
            + "   _ O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.view3.toString());
  }

  @Test
  public void testMoveToString3() {
    view3 = new TriangleSolitaireTextView(board4);
    board4.move(4, 0, 4, 2);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "_ _ O O O", this.view3.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new TriangleSolitaireTextView(board1, output);
    view3.renderBoard();
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", output.toString());
  }

  @Test
  public void testRenderBoard2() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new TriangleSolitaireTextView(board3, output);
    view3.renderBoard();
    assertEquals("      _\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", output.toString());
  }

  @Test
  public void testRenderMessage2() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new TriangleSolitaireTextView(board2, output);
    view3.renderMessage("Score: ");
    assertEquals("Score: ", output.toString());
  }

  @Test
  public void testRenderMessage3() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new TriangleSolitaireTextView(board2, output);
    view3.renderMessage("taro baap");
    assertEquals("taro baap", output.toString());
  }
}

