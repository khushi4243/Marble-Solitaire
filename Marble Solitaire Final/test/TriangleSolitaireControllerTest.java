import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * This tests the triangle controller.
 */
public class TriangleSolitaireControllerTest {
  @Test
  public void testPLayGameValid() {
    StringReader read = new StringReader("3 0 1 0 q");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 0\n"
            + "). \n", viewLog.toString());

    assertEquals("This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls move(2, -1, 0, -1). \n"
            + "This calls isGameOver(). \n"
            + "This calls getScore(). \n"
            + "This calls getScore(). \n", modelLog.toString());
  }

  @Test
  public void testPLayGameInvalid() {
    StringReader read = new StringReader("1 1 1 1 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderMessage(Invalid move. Play again. there is no marble at the "
            + "specified from position\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameFromRowQ() {
    StringReader read = new StringReader("q 1 1 1 2 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameFromColQ() {
    StringReader read = new StringReader("1 q 1 1 2 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameToRowQ() {
    StringReader read = new StringReader("1 1 q 1 q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n", viewLog.toString());
  }

  @Test
  public void testPLayGameToColQ() {
    StringReader read = new StringReader("1 1 1 q q");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderMessage(Game quit!\n"
            + "). \n"
            + "This calls renderMessage(State of game when quit:\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n", viewLog.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testPLayGameNoMoreInputs() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoreInputs() {
    StringReader read = new StringReader("");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testBadAppendable() {
    StringReader read = new StringReader("3 2 3 3");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextView(model, new WrongAppendable());
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullRead() {
    StringReader read = null;
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = new MarbleSolitaireModelMock(modelLog);
    MarbleSolitaireView viewMock = null;
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    StringReader read = new StringReader(" ");
    StringBuilder modelLog = new StringBuilder();
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel modelMock = null;
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(modelMock, viewMock, read);
    cont.playGame();
  }

  @Test
  public void testPLayEntireGame() {
    StringReader read = new StringReader("3 1 1 1\n"
            + "3 3 3 1\n"
            + "1 1 3 3\n"
            + "4 1 2 1\n"
            + "5 3 3 1\n"
            + "4 4 4 2\n"
            + "2 1 4 1\n"
            + "4 1 4 3\n"
            + "5 5 5 3\n"
            + "5 2 5 4\n"
            + "3 3 5 3\n"
            + "5 4 5 2\n"
            + "5 1 5 3\n");
    StringBuilder viewLog = new StringBuilder();
    MarbleSolitaireModel model = new TriangleSolitaireModel();
    MarbleSolitaireView viewMock = new MarbleSolitaireTextViewMock(viewLog);
    MarbleSolitaireControllerImpl cont =
            new MarbleSolitaireControllerImpl(model, viewMock, read);
    cont.playGame();
    assertEquals("This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 14\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 13\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 12\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 11\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 10\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 9\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 8\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 7\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 6\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 5\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 4\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 3\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 2\n"
            + "). \n"
            + "This calls renderMessage(Game over!\n"
            + "). \n"
            + "This calls renderBoard(). \n"
            + "This calls renderMessage(\n"
            + "). \n"
            + "This calls renderMessage(Score: 1\n"
            + "). \n", viewLog.toString());
  }
}
