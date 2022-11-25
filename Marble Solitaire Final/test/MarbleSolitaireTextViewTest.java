import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the display of the board for English and European.
 */
public class MarbleSolitaireTextViewTest {
  private MarbleSolitaireModel board1;
  private MarbleSolitaireModel board2;
  private MarbleSolitaireModel board4;
  private MarbleSolitaireModel board5;

  private MarbleSolitaireModel euro1;
  private MarbleSolitaireModel euro2;
  private MarbleSolitaireModel euro3;
  private MarbleSolitaireModel euro4;

  private MarbleSolitaireView view1;
  private MarbleSolitaireView view3;

  private MarbleSolitaireView euroView;
  private MarbleSolitaireView euroView3;


  @Before
  public void initConditions() {
    this.board1 = new EnglishSolitaireModel();
    this.board2 = new EnglishSolitaireModel(4, 3);
    this.board4 = new EnglishSolitaireModel(5);
    this.board5 = new EnglishSolitaireModel(3, 3, 3);

    this.euro1 = new EuropeanSolitaireModel();
    this.euro2 = new EuropeanSolitaireModel(4, 3);
    this.euro3 = new EuropeanSolitaireModel(5);
    this.euro4 = new EuropeanSolitaireModel(3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullObject() {
    new MarbleSolitaireTextView(null);
  }


  @Test
  public void testToString() {
    view1 = new MarbleSolitaireTextView(board1);
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(board2);
    view3 = new MarbleSolitaireTextView(board4);
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(board5);
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O _ O O O\n"
            + "O O O O O O O\n" + "    O O O\n" + "    O O O", this.view1.toString());
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O O O O O\n"
            + "O O O _ O O O\n" + "    O O O\n" + "    O O O", view2.toString());

    assertEquals("        O O O O O\n" + "        O O O O O\n" + "        O O O O O\n"
            + "        O O O O O\n" + "O O O O O O O O O O O O O\n" + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n" + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n" + "        O O O O O\n" + "        O O O O O\n"
            + "        O O O O O\n" + "        O O O O O", this.view3.toString());
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O _ O O O\n"
            + "O O O O O O O\n" + "    O O O\n" + "    O O O", view4.toString());
  }

  @Test
  public void testEuroToString() {
    euroView = new MarbleSolitaireTextView(euro1);
    MarbleSolitaireView euroView2 = new MarbleSolitaireTextView(euro2);
    euroView3 = new MarbleSolitaireTextView(euro3);
    MarbleSolitaireView euroView4 = new MarbleSolitaireTextView(euro4);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", euroView.toString());

    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "  O O O O O\n"
            + "    O O O", euroView2.toString());
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", euroView3.toString());
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", euroView4.toString());
  }

  @Test
  public void testMoveToString() {
    view1 = new MarbleSolitaireTextView(board1);
    board1.move(5, 3, 3, 3);
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O O O O O\n"
            + "O O O _ O O O\n" + "    O _ O\n" + "    O O O", this.view1.toString());
  }

  @Test
  public void testMoveToString2() {
    view3 = new MarbleSolitaireTextView(board4);
    board4.move(4, 6, 6, 6);
    assertEquals("        O O O O O\n" + "        O O O O O\n" + "        O O O O O\n"
            + "        O O O O O\n" + "O O O O O O _ O O O O O O\n"
            + "O O O O O O _ O O O O O O\n" + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n" + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n" + "        O O O O O\n"
            + "        O O O O O\n" + "        O O O O O", this.view3.toString());
  }

  @Test
  public void testEuroMoveToString() {
    euroView = new MarbleSolitaireTextView(euro1);
    euro1.move(5, 3, 3, 3);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "  O O _ O O\n"
            + "    O O O", this.euroView.toString());
  }

  @Test
  public void testEuroMoveToString2() {
    euroView3 = new MarbleSolitaireTextView(euro3);
    euro3.move(4, 6, 6, 6);
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", this.euroView3.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new MarbleSolitaireTextView(board1, output);
    view3.renderBoard();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", output.toString());
  }

  @Test
  public void testRenderBoard4() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new MarbleSolitaireTextView(board4, output);
    view3.renderBoard();
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", output.toString());
  }


  @Test
  public void testRenderBoard2() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new MarbleSolitaireTextView(board2, output);
    view3.renderBoard();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O O O\n"
            + "    O O O", output.toString());
  }

  @Test
  public void testRenderEuroBoard() throws IOException {
    StringBuilder output = new StringBuilder();
    euroView = new MarbleSolitaireTextView(euro1, output);
    euroView.renderBoard();
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", output.toString());
  }

  @Test
  public void testRenderEuroBoard2() throws IOException {
    StringBuilder output = new StringBuilder();
    euroView3 = new MarbleSolitaireTextView(euro3, output);
    euroView3.renderBoard();
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", output.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new MarbleSolitaireTextView(board1, output);
    view3.renderMessage("Hello");
    assertEquals("Hello", output.toString());
  }

  @Test
  public void testRenderMessage2() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new MarbleSolitaireTextView(board2, output);
    view3.renderMessage("Score: ");
    assertEquals("Score: ", output.toString());
  }

  @Test
  public void testRenderMessage3() throws IOException {
    StringBuilder output = new StringBuilder();
    view3 = new MarbleSolitaireTextView(board2, output);
    view3.renderMessage("ur mom");
    assertEquals("ur mom", output.toString());
  }

  @Test
  public void testEuroRenderMessage() throws IOException {
    StringBuilder output = new StringBuilder();
    euroView = new MarbleSolitaireTextView(euro1, output);
    euroView.renderMessage("Score: ");
    assertEquals("Score: ", output.toString());
  }

}





